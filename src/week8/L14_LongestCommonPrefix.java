package week8;
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//

public class L14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new L14_LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int minLen = Integer.MAX_VALUE;
            String prefix = "";
            for (String str : strs) {
                if (str.length() < minLen) {
                    minLen = str.length();
                    prefix = str;
                }
            }
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                for (String str : strs) {
                    if (str.charAt(i) != prefix.charAt(i)) {
                        return prefix.substring(0, i);
                    }
                }
            }
            return prefix;

        }
    }

}