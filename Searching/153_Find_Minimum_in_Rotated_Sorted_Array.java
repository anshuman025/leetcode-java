/*
 * LeetCode 153 - Find Minimum in Rotated Sorted Array
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Approach:
 * Use Binary Search to find the minimum element.
 *
 * Compare nums[mid] with nums[e]:
 *
 * - If nums[mid] > nums[e], the minimum is to the right of mid.
 * - Otherwise, the minimum is at mid or somewhere to its left.
 *
 * We use while (s < e) because we are narrowing the search
 * until s and e point to the same minimum element.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findMin(int[] nums) {

        int s = 0;
        int e = nums.length - 1;

        while (s < e) {

            int mid = s + (e - s) / 2;

            if (nums[mid] > nums[e]) {
                // Minimum is on the right side of mid.
                s = mid + 1;
            } else {
                // Minimum could be mid or somewhere to the left.
                e = mid;
            }
        }

        // s == e, so e points to the minimum element.
        return nums[e];
    }
}