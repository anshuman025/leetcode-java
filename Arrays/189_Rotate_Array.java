/*
 * LeetCode 189 - Rotate Array
 *
 * Link:
 * https://leetcode.com/problems/rotate-array/
 *
 * ----------------------------------------------------
 * Approach 1: Brute Force + Modulo
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
 * ----------------------------------------------------
 *
 * Approach 2: Optimized Reversal
 *
 * 1. Reduce k using modulo.
 * 2. Reverse the entire array.
 * 3. Reverse the first k elements.
 * 4. Reverse the remaining elements.
 *
 * Example:
 *
 * nums = [1,2,3,4,5,6,7]
 * k = 3
 *
 * Reverse whole:
 * [7,6,5,4,3,2,1]
 *
 * Reverse first k:
 * [5,6,7,4,3,2,1]
 *
 * Reverse remaining:
 * [5,6,7,1,2,3,4]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Fully optimized.
 * ----------------------------------------------------
 */

class Solution {

    // Approach 1: Brute Force + Modulo
    public void rotateBruteForce(int[] nums, int k) {

        k %= nums.length;

        for (int r = 0; r < k; r++) {

            int last = nums[nums.length - 1];

            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }

            nums[0] = last;
        }
    }


    // Approach 2: Optimized Reversal
    public void rotate(int[] nums, int k) {

        k %= nums.length;

        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, k - 1);

        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int s, int e) {

        while (s < e) {

            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

            s++;
            e--;
        }
    }
}