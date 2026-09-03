/*
 * LeetCode 3876 - Construct Uniform Parity Array II
 * Daily Challenge
 *
 * Link: https://leetcode.com/problems/construct-uniform-parity-array-ii/
 *
 * Approach:
 * Find the smallest odd number.
 *
 * If an even number is smaller than the smallest odd number,
 * the array cannot be made to have uniform parity.
 *
 * Otherwise, it is possible.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean uniformArray(int[] nums1) {

        // Find the smallest odd number.
        int mOdd = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 == 1) {
                mOdd = Math.min(mOdd, num);
            }
        }

        /*
         * If an even number is smaller than the smallest odd number,
         * that odd number cannot be converted to even.
         */
        for (int num : nums1) {
            if (num % 2 == 0
                    && mOdd != Integer.MAX_VALUE
                    && num < mOdd) {

                return false;
            }
        }

        // Uniform parity can be constructed.
        return true;
    }
}