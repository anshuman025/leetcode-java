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
 * Before rotating, reduce k using modulo because
 * rotating the array nums.length times brings it
 * back to its original arrangement.
 *
 * Time Complexity: O(n × k)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Partially improved by reducing unnecessary rotations.
 * Further optimization is possible.
 */

class Solution {
    public void rotate(int[] nums, int k) {

        k %= nums.length;

        for (int r = 0; r < k; r++) {

            int last = nums[nums.length - 1];

            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }

            nums[0] = last;
        }
    }
}