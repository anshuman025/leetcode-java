/*
 * LeetCode 283 - Move Zeroes
 *
 * Link:
 * https://leetcode.com/problems/move-zeroes/
 *
 * ----------------------------------------------------
 * Approach 1: Move Non-Zero + Fill Zeroes
 *
 * 1. Move all non-zero elements to the front.
 * 2. Fill the remaining positions with zeroes.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * ----------------------------------------------------
 * Approach 2: Swap-Based Two Pointers
 *
 * Use two pointers:
 *
 * zero    -> position where the next non-zero belongs
 * current -> scans the array
 *
 * When a non-zero element is found, swap it with
 * the element at the zero pointer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Shorter one-pass solution.
 * ----------------------------------------------------
 */

class Solution {

    // Approach 1: Move Non-Zero + Fill Zeroes

    public void moveZeroesFirst(int[] nums) {

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


    // Approach 2: Swap-Based Two Pointers

    public void moveZeroes(int[] nums) {

        int zero = 0;

        for (int current = 0; current < nums.length; current++) {

            if (nums[current] != 0) {

                int temp = nums[zero];
                nums[zero] = nums[current];
                nums[current] = temp;

                zero++;
            }
        }
    }
}