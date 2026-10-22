/*
 * LeetCode 3942: Minimum Operations to Sort a Permutation
 * Problem Link: https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
 *
 * Approach:
 * 1. Find the position of 0 in the array.
 * 2. Check whether the permutation follows increasing order
 *    when traversed circularly in the forward direction.
 * 3. Check the same in the backward direction.
 * 4. Calculate the minimum operations for each valid case.
 * 5. Return -1 if neither direction can produce the sorted array.
 *
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 */

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (check(nums, zero, 1)) {
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }

        if (check(nums, zero, -1)) {
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private boolean check(int[] nums, int zero, int step) {
        int n = nums.length;
        int index = zero;

        for (int i = 0; i < n; i++) {
            if (nums[index] != i) {
                return false;
            }

            index = (index + step + n) % n;
        }

        return true;
    }
}