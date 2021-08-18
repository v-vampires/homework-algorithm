package week9;
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 


import java.util.Arrays;
import java.util.PriorityQueue;

public class L239_SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new L239_SlidingWindowMaximum().new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,-1},1)));
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<int[]/*num, index*/> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < k - 1; i++) {
                queue.offer(new int[]{nums[i], i});
            }
            for (int i = k-1; i < nums.length; i++) {
                queue.offer(new int[]{nums[i], i});
                int[] peek = queue.peek();
                while(i - peek[1] >= k){
                    queue.poll();
                    peek = queue.peek();
                }
                res[i-k+1] = peek[0];

            }
            return res;
        }
    }


}