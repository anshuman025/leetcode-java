/*
 * LeetCode 3870 - Count Commas in Range
 * Link: https://leetcode.com/problems/count-commas-in-range/
 *
 * Approach: Brute Force
 *
 * Go through every number from 1 to n.
 * For each number:
 * - Find the number of digits.
 * - Every group of 3 digits after the first group needs a comma.
 * - Number of commas = (digits - 1) / 3
 *
 * Example:
 * 1000      -> 4 digits -> 1 comma
 * 1000000   -> 7 digits -> 2 commas
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countCommas(int n) {

        int total = 0;

        for (int num = 1; num <= n; num++) {

            int digits = String.valueOf(num).length();

            int commas = (digits - 1) / 3;

            total += commas;
        }

        return total;
    }
}