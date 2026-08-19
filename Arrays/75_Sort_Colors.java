/*
 * LeetCode 75 - Sort Colors
 *
 * Link:
 * https://leetcode.com/problems/sort-colors/
 *
 * Approach:
 *
 * Count the number of 0s, 1s, and 2s in the array.
 * Then overwrite the array using those counts.
 *
 * Example:
 *
 * nums = [2,0,2,1,1,0]
 *
 * Count:
 * 0 -> 2
 * 1 -> 2
 * 2 -> 2
 *
 * Result:
 * [0,0,1,1,2,2]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * This solution is O(n) time and O(1) space.
 * A one-pass Dutch National Flag approach can
 * be explored as another approach.
 */

class Solution {
    public void sortColors(int[] nums) {

        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }

        int i = 0;

        while (zero > 0) {
            nums[i++] = 0;
            zero--;
        }

        while (one > 0) {
            nums[i++] = 1;
            one--;
        }

        while (two > 0) {
            nums[i++] = 2;
            two--;
        }
    }
}