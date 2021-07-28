package week6;
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
//
public class L55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new L55_JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(solution.canJump(new int[]{0}));
    }

    class Solution {
        public boolean canJump(int[] nums) {
            int k = 0;//当前所能跳到的最大距离，即能跳到的最大索引处
            for (int i = 0; i < nums.length; i++) {
                if(k < i){
                    return false;
                }
                k = Math.max(k, i + nums[i]);
            }
            return true;
        }
    }

}