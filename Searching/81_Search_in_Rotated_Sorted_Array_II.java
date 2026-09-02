/*
 * LeetCode 81 - Search in Rotated Sorted Array II
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * Approach:
 * Use Binary Search on the rotated sorted array.
 *
 * Unlike Problem 33, this array can contain duplicates.
 * When nums[s], nums[mid], and nums[e] are equal, we cannot
 * determine which half is sorted. In that case, safely shrink
 * both boundaries.
 *
 * Example:
 * nums = [2,5,6,0,0,1,2], target = 0
 * Output = true
 *
 * Time Complexity:
 * Average: O(log n)
 * Worst Case: O(n) because of duplicates.
 *
 * Space Complexity: O(1)
 */

class Solution {
    public boolean search(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            // Target found
            if (nums[mid] == target) {
                return true;
            }

            /*
             * If s, mid and e have the same value,
             * we cannot determine which half is sorted.
             *
             * Since nums[mid] is not the target, and all three
             * values are equal, it is safe to remove both ends.
             */
            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                s++;
                e--;
                continue;
            }

            // Left half is sorted
            if (nums[s] <= nums[mid]) {

                // Target lies in the sorted left half
                if (nums[s] <= target && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }

            } else {

                // Right half is sorted
                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        // Target does not exist
        return false;
    }
}