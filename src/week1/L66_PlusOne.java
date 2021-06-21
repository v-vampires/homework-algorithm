package week1;

import java.util.Arrays;

public class L66_PlusOne {
    public static void main(String[] args) {
        Solution solution = new L66_PlusOne().new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9})));
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int sum = digits[i] + carry;
                digits[i] = sum % 10;
                carry = sum / 10;
            }
            if (carry == 0) {
                return digits;
            }
            int[] r = new int[digits.length + 1];
            r[0] = carry;
            System.arraycopy(digits, 0, r, 1, digits.length);
            return r;
        }
    }

}