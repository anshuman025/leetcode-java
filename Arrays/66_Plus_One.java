/*
 * LeetCode 66 - Plus One
 * Link: https://leetcode.com/problems/plus-one/
 *
 * Approach:
 * - Start from the last digit.
 * - If the digit is less than 9, add 1 and return.
 * - If the digit is 9, make it 0 and carry moves left.
 * - If all digits are 9, create a new array with leading 1.
 *
 * Time: O(n)
 * Space: O(1) normally
 *        O(n) when all digits are 9
 */

class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] res = new int[n + 1];
        res[0] = 1;

        return res;
    }
}