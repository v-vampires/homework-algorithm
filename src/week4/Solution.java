package week4;



class Solution {
    private int m;
    private int n;
    boolean[][] visit;
    private int[] destination;
    private int[] dx = {0,1,0,-1};
    private int[] dy = {1,0,-1,0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.m = maze.length;
        this.n = maze[0].length;
        this.visit = new boolean[m][n];
        this.destination = destination;
        int startX = start[0];
        int startY = start[1];

        return dfs(maze, startX, startY);
    }

    private boolean dfs(int[][] maze, int x, int y){
        if(x == destination[0] && y == destination[1] && isValid(maze, destination)){
            return true;
        }else{
            if(!isValid(maze,x,y)){
                return false;
            }
            if(visit[x][y]){
                return false;
            }
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                if(dfs(maze, x+dx[i], y + dy[i])){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int[] destination) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            //验证4个方向有几个入口，有一个为正确
            if(isValid(maze, destination[0] + dx[i], destination[1] + dy[i])){
                count++;
            }
        }
        return count == 1;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        System.out.println("x=" + x + ", y="+y);
        return x >= 0 && x <= m-1 && y >=0 && y <= n-1 && maze[x][y] != 1;
    }

    public static void main(String[] args) {
        final boolean b = new Solution().hasPath(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}
                , new int[]{0, 4}, new int[]{4, 4});
        System.out.println(b);
    }
}