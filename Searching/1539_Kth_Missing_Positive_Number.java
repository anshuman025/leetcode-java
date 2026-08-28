/*
 * LeetCode 1539 - Kth Missing Positive Number
 *
 * Link:
 * https://leetcode.com/problems/kth-missing-positive-number/
 *
 * Approach:
 *
 * Use Binary Search to find the position where the kth
 * missing positive number belongs.
 *
 * Missing numbers before arr[m]:
 *
 * arr[m] - (m + 1)
 *
 * If missing < k:
 *     We need more missing numbers, so search right.
 *
 * Otherwise:
 *     We have reached/passed the kth missing number,
 *     so search left.
 *
 * After the search, e is the last position where the
 * number of missing values is less than k.
 *
 * Therefore:
 *
 * answer = k + e + 1
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findKthPositive(int[] arr, int k) {

        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {

            int m = s + (e - s) / 2;

            int miss = arr[m] - (m + 1);

            if (miss < k) {
                s = m + 1;

            } else {
                e = m - 1;
            }
        }

        return k + e + 1;
    }
}