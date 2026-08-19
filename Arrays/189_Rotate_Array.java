/*
 * LeetCode 189 - Rotate Array
 *
 * Link:
 * https://leetcode.com/problems/rotate-array/
 *
 * Approach:
 *
 * Rotate the array one position at a time.
 *
 * For every rotation:
 * 1. Save the last element.
 * 2. Shift every element one position to the right.
 * 3. Put the saved element at index 0.
 *
 * Time Complexity: O(n × k)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Not optimized.
 */

class Solution {
    public void rotate(int[] nums, int k) {

        for (int r = 0; r < k; r++) {

            int last = nums[nums.length - 1];

            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }

            nums[0] = last;
        }
    }
}