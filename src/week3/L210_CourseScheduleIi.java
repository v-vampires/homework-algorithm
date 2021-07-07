package week3;


import java.util.*;

public class L210_CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new L210_CourseScheduleIi().new Solution();
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses == 0) return new int[0];
            /**
             * 1,0
             * 2,0
             * 3,1
             * 3,2
             */
            //出边数组
            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }

            //建立入度表，计算每门课程有几门先修课程
            int[] inDegrees = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                inDegrees[prerequisite[0]]++;
                edges.get(prerequisite[1]).add(prerequisite[0]);
            }
            Queue<Integer> queue = new ArrayDeque<>();
            //找到入度为0的点为起点
            for (int i = 0; i < inDegrees.length; i++) {
                if (inDegrees[i] == 0) {
                    queue.offer(i);
                }
            }

            int index = 0;
            int[] res = new int[numCourses];
            while (!queue.isEmpty()) {
                final Integer cur = queue.poll();//当前节点
                res[index++] = cur;
                final List<Integer> list = edges.get(cur);
                for (Integer y : list) {
                    inDegrees[y]--;
                    if (inDegrees[y] == 0) {
                        queue.offer(y);
                    }
                }
            }
            if (index == numCourses) {
                return res;
            }
            return new int[0];
        }
    }
}