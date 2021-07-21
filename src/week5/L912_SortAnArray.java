package week5;

import java.util.Arrays;

/**
 * 快排思想：先处理本层逻辑（将所有数分为左右两个区间，中轴值防中间），再递归处理左区间、右区间！等同于树的前序遍历
 * 具体步骤
 * 1. 选取nums[left]为中轴值，即 pivot = nums[left]
 * 2. while(leftIndex < rightIndex)
 *      如果nums[rightIndex] >= pivot 则rightIndex--，//说明nums[rightIndex]不需要交换，直到nums[rightIndex] < pivot 停止
 *      将nums[rightIndex]放到左边： nums[leftIndex] = nums[rightIndex]
 *
 *      如果nums[leftIndex] <= pivot 则leftIndex--，//说明nums[leftIndex]不需要交换，直到nums[leftIndex] > pivot 停止
 *      将nums[leftIndex]放到右边： nums[rightIndex] = nums[leftIndex]
 *
 * 3. 循环退出时leftIndex == rightIndex,此时两个index都指向了中间位置，则将pivot放在中间 nums[leftIndex] = pivot;
 * 4. 处理左半边(left, leftIndex-1)
 * 5. 处理右半边(leftIndex+1, right)
 */
public class L912_SortAnArray {
    public static void main(String[] args) {
        Solution solution = new L912_SortAnArray().new Solution();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{4, 3, 1, 56, 8, 10})));
    }

    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int l = left;
            int r = right;
            int temp = nums[l];//选择最左边的作为比较的中轴值
            while (l < r) {
                while (r > l && nums[r] >= temp) {//先找右边，找到比中轴值小的值，这个值需要放到中轴的左边
                    r--;
                }
                //nums[r] < temp;
                nums[l] = nums[r];
                while (l < r && nums[l] <= temp) {//先找右边，找到比中轴值大的值，这个值需要放到中轴的右边
                    l++;
                }
                //nums[l] > temp;
                nums[r] = nums[l];
            }
            //l==r，就是中间位置，将中轴值放到中间位置
            nums[l] = temp;

            quickSort(nums, left, l - 1);//继续处理左半边数据
            quickSort(nums, l + 1, right);//继续处理右半边数据
        }
    }

}