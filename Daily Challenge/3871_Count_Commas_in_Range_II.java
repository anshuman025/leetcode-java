/*
 * LeetCode 3871 - Count Commas in Range II
 * Link: https://leetcode.com/problems/count-commas-in-range-ii/
 *
 * Approach: Optimized Range Counting
 *
 * Instead of checking every number from 1 to n,
 * group numbers based on how many commas they contain.
 *
 * 1 - 999                     -> 0 commas
 * 1,000 - 999,999             -> 1 comma
 * 1,000,000 - 999,999,999     -> 2 commas
 * 1,000,000,000 - ...         -> 3 commas
 *
 * For each group:
 * - Find the starting number.
 * - Find the ending number.
 * - Count how many numbers are in the group.
 * - Multiply by the number of commas per number.
 *
 * We move to the next group by multiplying start by 1000.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public long countCommas(long n) {

        long ans = 0;
        long s = 1000;
        long commas = 1;

        while (s <= n) {

            long e = s * 1000 - 1;

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