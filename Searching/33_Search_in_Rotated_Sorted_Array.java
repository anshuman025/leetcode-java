/*
 * LeetCode 33 - Search in Rotated Sorted Array
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Approach:
 * Use Binary Search.
 *
 * At every step, one half of the array will be sorted.
 * First identify which half is sorted, then check whether
 * the target lies inside that sorted half.
 *
 * If it does, search that half.
 * Otherwise, search the other half.
 *
 * Example:
 * nums = [4,5,6,7,0,1,2], target = 0
 * Output = 4
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int search(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[s] <= nums[mid]) {

                if (nums[s] <= target && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        return -1;
    }
}