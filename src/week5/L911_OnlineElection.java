package week5;
//在选举中，第 i 张票是在时间为 times[i] 时投给 persons[i] 的。
//
// 现在，我们想要实现下面的查询函数： TopVotedCandidate.q(int t) 将返回在 t 时刻主导选举的候选人的编号。
//
// 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
//
// 示例：
//
// 输入：["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,1
//5,20,25,30]],[3],[12],[25],[15],[24],[8]]
//输出：[null,0,1,1,0,0,1]
//解释：
//时间为 3，票数分布情况是 [0]，编号为 0 的候选人领先。
//时间为 12，票数分布情况是 [0,1,1]，编号为 1 的候选人领先。
//时间为 25，票数分布情况是 [0,1,1,0,0,1]，编号为 1 的候选人领先（因为最近的投票结果是平局）。
//在时间 15、24 和 8 处继续执行 3 个查询。
//
//
//
//
// 提示：
//
//
// 1 <= persons.length = times.length <= 5000
// 0 <= persons[i] <= persons.length
// times 是严格递增的数组，所有元素都在 [0, 10^9] 范围中。
// 每个测试用例最多调用 10000 次 TopVotedCandidate.q。
// TopVotedCandidate.q(int t) 被调用时总是满足 t >= times[0]。
//
// Related Topics 设计 数组 哈希表 二分查找

/**
 * 因为时间序列是递增的，根据时间t使用二分可以在times序列中知道<=t的最大值对应的index，也就是选票时间，
 * 根据选票时间找到0~index之间的选票信息进行统计，并找出最大值
 * 如果是平局则谁的lastIndex大，谁胜出,也就是>=则更新
 *
 * 优化：可以提前将每个时间节点的领先候选人先计算出来
 */
public class L911_OnlineElection {
    public static void main(String[] args) {
        TopVotedCandidate solution = new L911_OnlineElection().new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0},
                new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(solution.q(3));
        System.out.println(solution.q(12));
        System.out.println(solution.q(25));
        System.out.println(solution.q(15));
        System.out.println(solution.q(24));
        System.out.println(solution.q(8));

    }

    class TopVotedCandidate {

        private int[] persons;
        private int[] times;
        private int[] candidate;//candidate[i]表示在时间索引i处票数最多的候选人

        public TopVotedCandidate(int[] persons, int[] times) {
            this.persons = persons;
            this.times = times;

            int[] count = new int[persons.length + 1];//候选人对应的票数统计
            candidate = new int[persons.length];
            int maxCandi = -1;//选票最多的候选人
            for (int i = 0; i < persons.length; i++) {
                int p = persons[i];
                count[p]++;
                if (i == 0 || count[p] >= count[maxCandi]) {
                    maxCandi = p;
                }
                candidate[i] = maxCandi;

            }
        }

        public int q(int t) {
            int index = find(t);
            return candidate[index];
        }

        private int find(int t) {
            int left = 0;
            int right = times.length - 1;
            int ans = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (times[mid] <= t) {
                    ans = Math.max(ans, mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

    }

}