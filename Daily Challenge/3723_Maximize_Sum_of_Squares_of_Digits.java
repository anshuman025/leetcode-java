/*
 * LeetCode 3723 - Maximize Sum of Squares of Digits
 *
 * Difficulty: Medium
 * Topics: Greedy, String
 *
 * Problem:
 * Given two positive integers num and sum, construct a positive
 * integer with exactly num digits whose digits add up to sum.
 *
 * Maximize the sum of the squares of its digits.
 * If multiple answers achieve the maximum score, return the
 * numerically largest integer as a string.
 *
 * Return an empty string if no valid integer exists.
 *
 * LeetCode:
 * https://leetcode.com/problems/maximize-sum-of-squares-of-digits/
 *
 * Approach:
 * 1. If sum > 9 * num, no valid number exists.
 * 2. Place as many 9s as possible from left to right.
 * 3. Place the remaining sum in the next digit.
 * 4. Fill the remaining positions with zeros.
 *
 * Greedy Idea:
 * Concentrating the digit sum into fewer digits maximizes
 * the sum of squared digits.
 *
 * Time Complexity: O(num)
 * Space Complexity: O(num)
 */

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            ans.append(digit);
            sum -= digit;
        }

        return ans.toString();
    }
}