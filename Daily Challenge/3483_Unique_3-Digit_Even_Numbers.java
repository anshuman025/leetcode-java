/*
 * LeetCode 3483 - Unique 3-Digit Even Numbers
 * Link: https://leetcode.com/problems/unique-3-digit-even-numbers/
 *
 * Approach: Frequency Counting + Enumeration
 *
 * Count how many times each digit appears.
 *
 * Then check every possible three-digit even number.
 * For each number, check whether the required digits
 * are available in the input with the required frequency.
 *
 * A number:
 * - Must be three digits, so it starts from 100.
 * - Must be even, so its last digit must be even.
 * - Cannot have a leading zero.
 * - Each digit can only be used as many times as it
 *   appears in the input.
 *
 * Time Complexity: O(n + 450)
 * Space Complexity: O(1)
 */

class Solution {
    public int totalNumbers(int[] digits) {

        int[] count = new int[10];

        for (int d : digits) {
            count[d]++;
        }

        int uniqueCount = 0;

        for (int num = 100; num <= 998; num += 2) {

            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            int[] needed = new int[10];

            needed[d1]++;
            needed[d2]++;
            needed[d3]++;

            if (count[d1] >= needed[d1] &&
                    count[d2] >= needed[d2] &&
                    count[d3] >= needed[d3]) {

                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}