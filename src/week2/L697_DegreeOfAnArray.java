package week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class L697_DegreeOfAnArray {
  public static void main(String[] args) {
       Solution solution = new L697_DegreeOfAnArray().new Solution();
      System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
      System.out.println(solution.findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
  }
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, NumDetail> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final NumDetail numDetail = map.getOrDefault(nums[i], new NumDetail());
            numDetail.count++;
            if(numDetail.minIndex == null){
                numDetail.minIndex = i;
            }
            numDetail.maxIndex = i;
            map.put(nums[i], numDetail);
        }
        final ArrayList<NumDetail> numDetails = new ArrayList<>(map.values());
        numDetails.sort((o1, o2) -> {
            if(o1.count == o2.count){
                return o1.getIndexDistance() - o2.getIndexDistance();
            }else{
                return o2.count - o1.count;
            }
        });
        return numDetails.get(0).getIndexDistance()+1;
    }

    private class NumDetail{
        public int count;
        public Integer minIndex;
        public Integer maxIndex;

        public int getIndexDistance(){
            return maxIndex - minIndex;
        }
    }
}

}