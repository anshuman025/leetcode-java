/*
 * LeetCode 2333 - Minimum Sum of Squared Difference
 *
 * Problem:
 * Minimize the sum of squared differences between two arrays
 * using at most k1 + k2 total operations.
 *
 * LeetCode:
 * https://leetcode.com/problems/minimum-sum-of-squared-difference/
 *
 * Approach:
 * 1. Calculate the absolute difference at each index.
 * 2. Use binary search to find the minimum possible maximum difference.
 * 3. Reduce larger differences as much as possible.
 * 4. Use any remaining operations to reduce differences by one.
 *
 * Time Complexity: O(n log M)
 * Space Complexity: O(n)
 *
 * M = maximum absolute difference.
 */

import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];
        int max = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            total += diff[i];
        }

        if (k >= total) {
            return 0;
        }

        int left = 0, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long remaining = k;
        long ans = 0;

        for (int d : diff) {
            if (d > left) {
                remaining -= d - left;
                ans += (long) left * left;
            } else {
                ans += (long) d * d;
            }
        }

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] >= left && diff[i] > 0) {
                ans -= (long) left * left;
                ans += (long) (left - 1) * (left - 1);
                remaining--;
            }
        }

        return ans;
    }
}