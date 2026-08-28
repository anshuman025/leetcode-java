/*
 * LeetCode 852 - Peak Index in a Mountain Array
 *
 * Link:
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * Approach:
 *
 * Use Binary Search by checking the direction of the slope.
 *
 * If arr[mid] > arr[mid + 1]:
 *     We are on the decreasing side.
 *     The peak is at mid or to the left.
 *     Therefore, e = mid.
 *
 * If arr[mid] < arr[mid + 1]:
 *     We are on the increasing side.
 *     The peak is to the right.
 *     Therefore, s = mid + 1.
 *
 * We use while (s < e) because we keep narrowing the
 * search range until only one possible peak remains.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int s = 0;
        int e = arr.length - 1;

        while (s < e) {

            int mid = s + (e - s) / 2;

            if (arr[mid] > arr[mid + 1]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return s;
    }
}
