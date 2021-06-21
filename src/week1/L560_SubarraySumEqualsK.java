package week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 利用前缀和公式s[i] = s[i-1] + a[i],获得前缀和数组
 * 2. 利用s[r] - s[l-1]=k 获取连续子数组和为k的子段（l，r）
 * 3. 优化：使用map记录s[l-1],类似于两数之和为target的方案
 */
public class L560_SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new L560_SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 2, 1, 2}, 3));
    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            int ans = 0;
            Map<Integer,/*sum[i], count*/ Integer> map = new HashMap<>();
            for (int i = 0; i < sum.length; i++) {
                final Integer count = map.getOrDefault(sum[i] - k, 0);
                ans += count;
                map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
            }
            return ans;
        }
    }

}