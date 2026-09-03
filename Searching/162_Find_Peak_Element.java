/*
 * LeetCode 162 - Find Peak Element
 * Link: https://leetcode.com/problems/find-peak-element/
 *
 * Approach:
 * Use Binary Search.
 *
 * Compare nums[mid] with nums[mid + 1].
 *
 * If nums[mid] > nums[mid + 1], we are on the decreasing side,
 * so a peak is at mid or somewhere to the left.
 *
 * Otherwise, we are on the increasing side,
 * so a peak must be to the right.
 *
 * We continue until s and e point to the same index.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findPeakElement(int[] arr) {

        int s = 0;
        int e = arr.length - 1;

        while (s < e) {

            int mid = s + (e - s) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // Decreasing side: peak is at mid or to the left.
                e = mid;
            } else {
                // Increasing side: peak must be to the right.
                s = mid + 1;
            }
        }

        // s == e, so this index is a peak.
        return e;
    }
}