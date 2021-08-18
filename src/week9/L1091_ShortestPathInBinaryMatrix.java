package week9;
//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 115 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class L1091_ShortestPathInBinaryMatrix {
  public static void main(String[] args) {
       Solution solution = new L1091_ShortestPathInBinaryMatrix().new Solution();
      System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0,0,0}, {1,1,0}, {1,1,0}}));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }
        int[][] dir = {{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1}};
        int n = grid.length;
        boolean[][] used = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        used[0][0] = true;
        int ans = 1;
        while(!queue.isEmpty()){
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final int[] point = queue.poll();
                if(point[0] == n-1 && point[1] == n - 1) return ans;
                for (int[] ints : dir) {
                    int x = point[0] + ints[0];
                    int y = point[1] + ints[1];
                    if(x >=0 && x < n && y >=0 && y < n && grid[x][y]==0 && !used[x][y]){
                        queue.add(new int[]{x,y});
                        used[x][y] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}