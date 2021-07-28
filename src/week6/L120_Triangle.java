package week6;
//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
// 示例 2：
//
//
//输入：triangle = [[-10]]
//输出：-10
//
//
//
//
// 提示：
//
//
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -104 <= triangle[i][j] <= 104
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 感觉像是求一棵二叉树的最小路径，所以
 * 方案1：递归+记忆化：triangle[depth][index] + Math.min(minimumTotal(triangle, depth + 1, index), minimumTotal(triangle, depth + 1, index + 1));
 * 方案2：动规：dp[i][j] = triangle[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1])； 初始化dp[m-1][n-1], 返回dp[0][0]
 */
public class L120_Triangle {
    public static void main(String[] args) {
        Solution solution = new L120_Triangle().new Solution();
        final ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(solution.minimumTotal2(lists));
    }

    class Solution {

        private int[][] memo;

        public int minimumTotal(List<List<Integer>> triangle) {
            memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
            for (int[] ints : memo) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            int startIndex = 0;
            int depth = 0;
            return minimumTotal(triangle, depth, startIndex);
        }

        private int minimumTotal(List<List<Integer>> triangle, int depth, int index) {
            if (depth >= triangle.size()) {
                return 0;
            }
            if (memo[depth][index] != Integer.MAX_VALUE) {
                return memo[depth][index];
            }
            int v = triangle.get(depth).get(index) + Math.min(minimumTotal(triangle, depth + 1, index), minimumTotal(triangle, depth + 1, index + 1));
            memo[depth][index] = v;
            return v;
        }


        public int minimumTotal2(List<List<Integer>> triangle) {
            int m = triangle.size(), n = triangle.get(triangle.size() - 1).size();
            int[][] dp = new int[m][n];
            for (int i = m - 1; i >= 0; i--) {
                final List<Integer> sub = triangle.get(i);
                for (int j = 0; j < sub.size(); j++) {
                    if(i == m -1){
                        dp[i][j] = sub.get(j);
                    }else{
                        dp[i][j] = sub.get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                    }
                }
            }
            return dp[0][0];
        }


    }

}