/*
 * LeetCode 88 - Merge Sorted Array
 *
 * Link:
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * Approach:
 *
 * Use three pointers and merge the arrays from the end.
 *
 * i -> last actual element in nums1
 * j -> last element in nums2
 * k -> last position in nums1
 *
 * Compare nums1[i] and nums2[j].
 * Place the larger element at nums1[k].
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Already optimized.
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {

            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }
    }
}