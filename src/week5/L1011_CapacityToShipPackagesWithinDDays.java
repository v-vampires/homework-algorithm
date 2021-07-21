package week5;
//传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
//
// 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
//
// 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
//
//
//
// 示例 1：
//
//
//输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//输出：15
//解释：
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10
//
//请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (1
//0) 是不允许的。
//
//
// 示例 2：
//
//
//输入：weights = [3,2,2,4,1,4], D = 3
//输出：6
//解释：
//船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
//第 1 天：3, 2
//第 2 天：2, 4
//第 3 天：1, 4
//
//
// 示例 3：
//
//
//输入：weights = [1,2,3,1,1], D = 4
//输出：3
//解释：
//第 1 天：1
//第 2 天：2
//第 3 天：3
//第 4 天：1, 1
//
//
//
//
// 提示：
//
//
// 1 <= D <= weights.length <= 5 * 104
// 1 <= weights[i] <= 500
//
// Related Topics 贪心 数组 二分查找

/**
 * 因为我们并不知道答案，但是答案m肯定满足 当ans<m时，无法将货物D天内送达，而ans>=m时，可以在D天内送达
 * 所以利用二分+贪心，不断的探测寻找到m值，也就是答案值
 */
public class L1011_CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Solution solution = new L1011_CapacityToShipPackagesWithinDDays().new Solution();
        System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(solution.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }

    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            //因为我们并不知道答案，但是答案m肯定满足 当ans<m时，无法将货物D天内送达，而ans>=m时，可以在D天内送达
            //所以利用二分+贪心，不断的探测寻找到m值，也就是答案值
            int min = 0;//最低载重
            int max = 0;//最高载重
            for (int weight : weights) {
                min = Math.max(min, weight);
                max = max + weight;
            }
            while (min < max) {
                int mid = (min + max) / 2;
                if (isValid(weights, mid, days)) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            //min = max;
            return min;
        }

        private boolean isValid(int[] weights, int mid, int days) {
            int weightSum = 0;
            int dayCount = 1;
            for (int weight : weights) {
                if (weightSum + weight <= mid) {
                    weightSum += weight;
                } else {
                    dayCount++;
                    weightSum = weight;
                }
            }
            return dayCount <= days;
        }
    }

}