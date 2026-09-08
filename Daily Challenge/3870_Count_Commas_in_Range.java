/*
 * LeetCode 3870 - Count Commas in Range
 *
 * Link: https://leetcode.com/problems/count-commas-in-range/
 *
 * ----------------------------------------------------
 * Approach 1: Brute Force
 * ----------------------------------------------------
 * Go through every number from 1 to n.
 *
 * For each number:
 * - Find the number of digits.
 * - Calculate the number of commas using:
 *
 *      commas = (digits - 1) / 3
 *
 * Add the commas to the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 *
 * ----------------------------------------------------
 * Approach 2: Optimized
 * ----------------------------------------------------
 * Instead of checking every number, group numbers
 * according to how many commas they contain.
 *
 * 1 - 999                   -> 0 commas
 * 1,000 - 999,999           -> 1 comma
 * 1,000,000 - 999,999,999   -> 2 commas
 *
 * For each group:
 * - Find its starting number.
 * - Find its ending number.
 * - Count how many numbers are in the group.
 * - Multiply by the number of commas per number.
 *
 * We jump from one group to the next using:
 *
 *      start *= 1000
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countCommas(int n) {

        /*
         * ------------------------------------------------
         * Approach 1: Brute Force
         * ------------------------------------------------
         *
         * Uncomment this section to use the brute-force
         * solution.
         */


        int ans = 0;

        for (int num = 1; num <= n; num++) {

            int digits = String.valueOf(num).length();

            int commas = (digits - 1) / 3;

            ans += commas;
        }

        return ans;



        /*
         * ------------------------------------------------
         * Approach 2: Optimized
         * ------------------------------------------------
         */

        int ans = 0;
        int s = 1000;
        int commas = 1;

        while (s <= n) {

            long e = (long) s * 1000 - 1;

            if (e > n) {
                e = n;
            }

            ans += (e - s + 1) * commas;

            s *= 1000;
            commas++;
        }

        return ans;
    }
}