/*
 * Problem: 462. Minimum Moves to Equal Array Elements II
 * Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 *
 * Approach: Sorting + Median
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 */

import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {

        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        long moves = 0;

        for (int num : nums) {
            moves += Math.abs((long) num - median);
        }

        return (int) moves;
    }
}