/*
 * LeetCode 35 - Search Insert Position
 *
 * Link:
 * https://leetcode.com/problems/search-insert-position/
 *
 * Approach:
 *
 * Use Binary Search.
 *
 * If nums[mid] == target:
 *     Target found, return mid.
 *
 * If nums[mid] > target:
 *     Search left.
 *
 * If nums[mid] < target:
 *     Search right.
 *
 * If target is not found, e will be the last index
 * containing a value smaller than target.
 *
 * Therefore, the insertion position is e + 1.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int searchInsert(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;

            } else if (nums[mid] > target) {
                e = mid - 1;

            } else {
                s = mid + 1;
            }
        }

        return e + 1;
    }
}