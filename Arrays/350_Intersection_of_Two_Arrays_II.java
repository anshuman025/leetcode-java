/*
 * LeetCode 350 - Intersection of Two Arrays II
 *
 * Link:
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Approach:
 *
 * Sort both arrays first.
 *
 * Then use two pointers:
 *     i → nums1
 *     j → nums2
 *
 * If nums1[i] == nums2[j]:
 *     Add the number to the result.
 *     Move both pointers.
 *
 * If nums1[i] < nums2[j]:
 *     Move i because nums1[i] is too small.
 *
 * If nums1[i] > nums2[j]:
 *     Move j because nums2[j] is too small.
 *
 * Moving both pointers after a match naturally handles
 * duplicate values.
 *
 * Example:
 *
 * nums1 = [4,9,5]
 * nums2 = [9,4,9,8,4]
 *
 * After sorting:
 *
 * nums1 = [4,5,9]
 * nums2 = [4,4,8,9,9]
 *
 * Common values:
 *     4 → included once
 *     9 → included once
 *
 * Result:
 * [4,9]
 *
 * Time Complexity:
 * O(n log n + m log m)
 *
 * Space Complexity:
 * O(1) extra space, excluding the result and sorting
 * implementation.
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {
                i++;

            } else {
                j++;
            }
        }

        int[] res = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }

        return res;
    }
}