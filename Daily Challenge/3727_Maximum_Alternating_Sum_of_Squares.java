/*
 * LeetCode 3727 - Maximum Alternating Sum of Squares
 *
 * Difficulty: Medium
 * Topics: Greedy, Sorting, Arrays
 *
 * Problem:
 * Given an integer array nums, rearrange its elements to maximize
 * the alternating score:
 *
 * nums[0]^2 - nums[1]^2 + nums[2]^2 - nums[3]^2 + ...
 *
 * Return the maximum possible alternating score.
 *
 * LeetCode:
 * https://leetcode.com/problems/maximum-alternating-sum-of-squares/
 *
 * Approach:
 * 1. Square every element because negative values also produce
 *    non-negative squares.
 * 2. Sort the squared values in ascending order.
 * 3. Subtract the smallest n / 2 squared values.
 * 4. Add the remaining squared values.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long ans = 0;
        int n = squares.length;

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                ans -= squares[i];
            } else {
                ans += squares[i];
            }
        }

        return ans;
    }
}