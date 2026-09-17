/*
 * LeetCode 1477 - Find Two Non-overlapping Sub-arrays Each With Target Sum
 * Link: https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 *
 * Approach:
 * Sliding Window + DP
 *
 * Since all array values are positive, use a sliding window
 * to find subarrays with sum equal to target.
 *
 * best[i] stores the minimum length of a valid subarray
 * found from index 0 to i.
 *
 * When a target-sum subarray is found, combine it with the
 * best valid subarray ending before its starting position.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                minLength = Math.min(minLength, len);
            }

            best[right] = minLength;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}