/*
 * LeetCode 3903 - Smallest Stable Index I
 * Link: https://leetcode.com/problems/smallest-stable-index-i/
 *
 * Approach: Brute Force
 *
 * For every index i:
 * 1. Find the maximum value from index 0 to i.
 * 2. Find the minimum value from index i to the end.
 * 3. Calculate max - min.
 * 4. If max - min <= k, return i.
 *
 * The first index that satisfies the condition is the
 * smallest stable index.
 *
 * Example:
 * nums = [5, 0, 1, 4], k = 3
 *
 * i = 0 -> max = 5, min = 0 -> 5 - 0 = 5  -> not stable
 * i = 1 -> max = 5, min = 0 -> 5 - 0 = 5  -> not stable
 * i = 2 -> max = 5, min = 1 -> 5 - 1 = 4  -> not stable
 * i = 3 -> max = 5, min = 4 -> 5 - 4 = 1  -> stable
 *
 * Answer = 3
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

class Solution {
    public int firstStableIndex(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            // Find maximum from index 0 to i
            int max = 0;

            for (int j = 0; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }

            // Find minimum from index i to the end
            int min = nums[i];

            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
            }

            // Check if current index is stable
            if (max - min <= k) {
                return i;
            }
        }

        return -1;
    }
}