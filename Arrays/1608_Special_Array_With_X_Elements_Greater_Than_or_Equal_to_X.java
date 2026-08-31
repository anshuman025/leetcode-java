/*
 * LeetCode 1608 - Special Array With X Elements Greater Than or Equal to X
 *
 * Link:
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-to-x/
 *
 * Approach:
 *
 * Try every possible value of x from 0 to nums.length.
 *
 * For each x, count how many elements in the array are
 * greater than or equal to x.
 *
 * If the count is exactly equal to x, then x is the
 * special value and we return it.
 *
 * If no value of x satisfies the condition, return -1.
 *
 * Example:
 *
 * nums = [3,5]
 *
 * x = 2:
 *
 *     3 >= 2 → yes
 *     5 >= 2 → yes
 *
 * count = 2
 * x = 2
 *
 * Since count == x, return 2.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */

class Solution {
    public int specialArray(int[] nums) {

        for (int x = 0; x <= nums.length; x++) {

            int count = 0;

            for (int num : nums) {

                if (num >= x) {
                    count++;
                }
            }

            if (count == x) {
                return x;
            }
        }

        return -1;
    }
}