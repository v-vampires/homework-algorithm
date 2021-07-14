package week4;

public class L154_FindMinimumInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new L154_FindMinimumInRotatedSortedArrayIi().new Solution();
        System.out.println(solution.findMin(new int[]{10, 1, 10, 10, 10}));
    }

    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < nums[right]) {//mid在右半边，最小值则在mid左边，或者是mid
                    right = mid;
                } else if (nums[mid] > nums[right]) {//mid在左半边，最小值则在mid右边
                    left = mid + 1;
                } else {//相等的话，只能逐渐减少right进行检查
                    right--;
                }
            }
            return nums[left];
        }
    }

}