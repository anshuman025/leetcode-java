/*
 * LeetCode 3551 - Minimum Swaps to Sort by Digit Sum
 *
 * Difficulty: Medium
 * Topics: Array, Sorting, Greedy
 *
 * Problem:
 * Given an array of distinct positive integers, sort the elements
 * by digit sum in ascending order. If two elements have the same
 * digit sum, the smaller integer comes first.
 *
 * Return the minimum number of swaps required to achieve this order.
 *
 * LeetCode:
 * https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/
 *
 * Approach:
 * 1. Store each number with its original index.
 * 2. Sort the elements by digit sum, then by their values.
 * 3. Track the original positions of elements.
 * 4. Count the swaps needed to place every element in its
 *    correct sorted position using cycle detection.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = digitSum(nums[i]);
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}