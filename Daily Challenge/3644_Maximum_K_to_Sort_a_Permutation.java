/*
 * LeetCode 3644: Maximum K to Sort a Permutation
 * Problem Link: https://leetcode.com/problems/maximum-k-to-sort-a-permutation/
 *
 * Approach: Bit Manipulation
 *
 * 1. Traverse the array and find elements that are not at their
 *    correct indices.
 * 2. Calculate the bitwise AND of all misplaced elements.
 * 3. This AND gives the maximum possible value of k.
 * 4. If the array is already sorted, return 0.
 *
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 */

class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                ans &= nums[i];
            }
        }

        return Math.max(ans, 0);
    }
}