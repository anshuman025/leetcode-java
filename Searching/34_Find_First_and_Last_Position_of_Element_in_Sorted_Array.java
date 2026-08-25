/*
 * LeetCode 34 - Find First and Last Position of Element in Sorted Array
 *
 * Link:
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Approach:
 *
 * Use binary search twice.
 *
 * First binary search:
 * Find the first occurrence of target.
 * When target is found, store the index and continue searching left.
 *
 * Second binary search:
 * Find the last occurrence of target.
 * When target is found, store the index and continue searching right.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Already optimized.
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                res[0] = mid;
                e = mid - 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        s = 0;
        e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                res[1] = mid;
                s = mid + 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return res;
    }
}