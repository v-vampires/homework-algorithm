package week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        final List<List<Integer>> lists = new Solution().fourSum(new int[]{2,2,2,2,2}, 8);
        System.out.println(lists);
    }
    private List<List<Integer>> res = new ArrayList<>();
    private int target;
    private Set<List<Integer>> set = new HashSet<List<Integer>>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.target = target;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        dfs(list, nums, sum, 0);
        return res;
    }

    private void dfs(List<Integer> list, int[] nums, int sum, int start){
        if(list.size() == 4){
            if(sum == this.target && !res.contains(list)){
                res.add(new ArrayList<>(list));
            }
        }else{
            for (int i = start; i < nums.length; i++) {
                sum += nums[i];
                list.add(nums[i]);
                dfs(list, nums, sum, i+1);
                sum -= nums[i];
                list.remove(list.size()-1);
            }
        }
    }
}