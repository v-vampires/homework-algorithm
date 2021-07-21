package week5;
//珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
//
// 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//
// 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
//
//
//
//
//
//
// 示例 1：
//
// 输入: piles = [3,6,7,11], H = 8
//输出: 4
//
//
// 示例 2：
//
// 输入: piles = [30,11,23,4,20], H = 5
//输出: 30
//
//
// 示例 3：
//
// 输入: piles = [30,11,23,4,20], H = 6
//输出: 23
//
//
//
//
// 提示：
//
//
// 1 <= piles.length <= 10^4
// piles.length <= H <= 10^9
// 1 <= piles[i] <= 10^9
//
// Related Topics 数组 二分查找

/**
 * 因为要求的最小速度K具有单调性，当 K < m 时所需要的时间肯定都>H,当 K >= m 时所需要的时间肯定都<=H
 * 所以本质还是二分答案
 */
public class L875_KokoEatingBananas {
  public static void main(String[] args) {
       Solution solution = new L875_KokoEatingBananas().new Solution();
      System.out.println(solution.minEatingSpeed(new int[]{3,6,7,11}, 8));
      System.out.println(solution.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
      System.out.println(solution.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long min = 1;
        long max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        while(min < max){
            final long mid = (min + max) / 2;
            if(isValid(piles, mid, h)){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return (int) min;
    }

      private boolean isValid(int[] piles, long k, int h) {
        long time = 0;
        for (int pile : piles) {
              time = time +( pile % k == 0 ? pile / k : pile / k + 1);
          }
        return time <= h;
      }


  }
//leetcode submit region end(Prohibit modification and deletion)

}