package week3;


import java.util.Arrays;

public class L130_SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new L130_SurroundedRegions().new Solution();
        final char[][] chars = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution.solve(chars);
        System.out.println(Arrays.toString(chars));
    }

    class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                dfs(board, i, 0);
                dfs(board, i, n - 1);
            }
            for (int j = 0; j < n; j++) {
                dfs(board, 0, j);
                dfs(board, m - 1, j);
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'T') {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'T';
            dfs(board, x - 1, y);
            dfs(board, x + 1, y);
            dfs(board, x, y - 1);
            dfs(board, x, y + 1);
        }
    }

}