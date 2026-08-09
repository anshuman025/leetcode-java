/*
 * LeetCode 1304 - Find N Unique Integers Sum up to Zero
 * Link: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 *
 * Approach:
 * - Create pairs of numbers: -i and +i.
 * - Every pair cancels out and gives 0.
 * - If n is odd, add 0 as the extra number.
 *
 * Example:
 * n = 6
 * [-1, 1, -2, 2, -3, 3]
 *
 * n = 7
 * [-1, 1, -2, 2, -3, 3, 0]
 *
 * Time: O(n)
 * Space: O(n)
 */

class Solution {
    public int[] sumZero(int n) {

        int[] ans = new int[n];

        int index = 0;

        for (int i = 1; i <= n / 2; i++) {
            ans[index++] = -i;
            ans[index++] = i;
        }

        if (n % 2 != 0) {
            ans[index] = 0;
        }

        return ans;
    }
}