/*
 * LeetCode 283 - Move Zeroes
 *
 * Link:
 * https://leetcode.com/problems/move-zeroes/
 *
 * Approach:
 *
 * Use two phases.
 *
 * 1. Move all non-zero elements to the front.
 * 2. Fill the remaining positions with zeroes.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * O(n) time and O(1) space.
 * A shorter swap-based approach can be explored.
 */

class Solution {
    public void moveZeroes(int[] nums) {

        int zero = 0;

        for (int current = 0; current < nums.length; current++) {

            if (nums[current] != 0) {
                nums[zero] = nums[current];
                zero++;
            }
        }

        while (zero < nums.length) {
            nums[zero] = 0;
            zero++;
        }
    }
}