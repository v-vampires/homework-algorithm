package week6;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶

/**
 * 状态：1~n，楼梯的阶数
 * 目标：每个阶数，对应的爬法
 * f[n]对应的爬法要么是直接从n-1爬上来，要么是从n-2 爬上来，注意：不考虑从n-2 先到n-1 再到n，这样就和n-1的爬法重复了
 */
public class L70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new L70_ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(3));

    }

    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

}