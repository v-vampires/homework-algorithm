package week8;
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

import java.util.ArrayList;
import java.util.List;

public class L438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new L438_FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (p.length() > s.length()) {
                return res;
            }
            int pLen = p.length();
            int[] pArr = new int[26];
            int[] sArr = new int[26];
            for (int i = 0; i < pLen; i++) {
                pArr[p.charAt(i) - 'a']++;
                sArr[s.charAt(i) - 'a']++;
            }
            if (arrEquals(sArr, pArr)) {
                res.add(0);
            }
            for (int i = pLen; i < s.length(); i++) {
                final int pre = i - pLen;
                sArr[s.charAt(pre) - 'a']--;
                sArr[s.charAt(i) - 'a']++;
                if (arrEquals(sArr, pArr)) {
                    res.add(i + 1 - pLen);
                }
            }
            return res;
        }

        private boolean arrEquals(int[] sArr, int[] pArr) {
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] != pArr[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}