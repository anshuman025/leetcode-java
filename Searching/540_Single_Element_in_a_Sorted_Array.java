/*
 * LeetCode 540 - Single Element in a Sorted Array
 *
 * Link:
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * Approach:
 *
 * Use Binary Search on the sorted array.
 *
 * Every element appears exactly twice except one element.
 *
 * Before the single element, pairs start at even indexes:
 *
 *     [1,1] [2,2] [3,3]
 *       0,1   2,3   4,5
 *
 * After the single element, this pairing pattern is
 * shifted by one position.
 *
 * We make mid even so that we can compare:
 *
 *     nums[mid] and nums[mid + 1]
 *
 * If they are equal:
 *     The pair is correct, so the single element is
 *     somewhere to the right.
 *
 *     s = mid + 2
 *
 * If they are not equal:
 *     The pairing pattern is broken, so the single
 *     element is at mid or somewhere to the left.
 *
 *     e = mid
 *
 * We use while(s < e) because eventually s and e
 * meet at the single element.
 *
 * Example:
 *
 * nums = [1,1,2,2,3,4,4,5,5]
 *
 * The pairing breaks at 3, so the answer is 3.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {

        int s = 0;
        int e = nums.length - 1;

        while (s < e) {

            int mid = s + (e - s) / 2;

            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                s = mid + 2;
            } else {
                e = mid;
            }
        }

        return nums[s];
    }
}