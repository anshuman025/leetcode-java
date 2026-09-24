/*
 * LeetCode 3550 - Smallest Index With Digit Sum Equal to Index
 *
 * Approach:
 * Check every index from left to right.
 * Calculate the digit sum of nums[i].
 * If the digit sum equals the index, return that index.
 *
 * Time Complexity: O(n * d)
 * Space Complexity: O(1)
 */

class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
}