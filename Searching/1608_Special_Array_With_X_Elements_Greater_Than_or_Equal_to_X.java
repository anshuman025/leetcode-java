/*
 * LeetCode 1608 - Special Array With X Elements Greater Than or Equal to X
 *
 * Link:
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-to-x/
 *
 * Approach:
 *
 * First sort the array.
 *
 * Then try every possible value of x from 0 to nums.length.
 *
 * For each x, use Binary Search to find the first element
 * that is greater than or equal to x.
 *
 * Once the first such element is found:
 *
 *     count = nums.length - first
 *
 * This gives the number of elements that are >= x.
 *
 * If count == x, then x is the required special value.
 *
 * Example:
 *
 * nums = [3,5]
 *
 * x = 2
 *
 * First element >= 2 is at index 0.
 *
 * count = 2 - 0
 *       = 2
 *
 * Since count == x, return 2.
 *
 * Binary Search:
 *
 * If nums[mid] >= x:
 *     Store mid as a possible first position.
 *     Search left for an earlier valid position.
 *
 * Else:
 *     Search right.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) extra
 */

class Solution {
    public int specialArray(int[] nums) {

        Arrays.sort(nums);

        for (int x = 0; x <= nums.length; x++) {

            int s = 0;
            int e = nums.length - 1;
            int f = nums.length;

            while (s <= e) {

                int mid = s + (e - s) / 2;

                if (nums[mid] >= x) {
                    f = mid;
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }

            int count = nums.length - f;

            if (count == x) {
                return x;
            }
        }

        return -1;
    }
}