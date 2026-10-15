/*
 * LeetCode 2913 - Subarrays Distinct Element Sum of Squares I
 *
 * Difficulty: Easy
 * Topics: Array, HashSet
 *
 * Problem:
 * Given an integer array nums, find the sum of the squares of
 * the number of distinct elements in every non-empty subarray.
 *
 * LeetCode:
 * https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/
 *
 * Approach:
 * 1. Fix the starting index of each subarray.
 * 2. Extend the subarray one element at a time.
 * 3. Use a HashSet to track distinct elements.
 * 4. Square the set's size and add it to the answer.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> distinct = new HashSet<>();

            for (int j = i; j < n; j++) {
                distinct.add(nums.get(j));

                int count = distinct.size();
                ans += count * count;
            }
        }

        return ans;
    }
}