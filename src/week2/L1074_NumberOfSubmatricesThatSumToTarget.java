package week2;

public class L1074_NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {
        Solution solution = new L1074_NumberOfSubmatricesThatSumToTarget().new Solution();
        System.out.println(solution.numSubmatrixSumTarget(new int[][]{{1, -1}, {-1, 1}}, 0));
    }

    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] sum = new int[m + 1][n + 1];
            //求前缀和
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i - 1][j - 1] - sum[i - 1][j - 1];
                }
            }
            int ans = 0;
            for (int up = 1; up <= m; up++) {
                for (int right = 1; right <= n; right++) {
                    for (int down = 0; down < up; down++) {
                        for (int left = 0; left < right; left++) {
                            if (sum[up][right] - sum[up][left] - sum[down][right] + sum[down][left] == target) {
                                ans++;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
}