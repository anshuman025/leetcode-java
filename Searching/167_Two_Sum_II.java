/*
 * LeetCode 167 - Two Sum II: Input Array Is Sorted
 *
 * Link:
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Approach:
 *
 * Use two pointers:
 *
 * s -> starts from the beginning
 * e -> starts from the end
 *
 * If the sum is greater than target:
 *     Move e left to make the sum smaller.
 *
 * If the sum is less than target:
 *     Move s right to make the sum bigger.
 *
 * If the sum equals target:
 *     Return the 1-based indexes.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Two-pointer approach.
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int s = 0;
        int e = numbers.length - 1;

        while (s < e) {

            if (numbers[s] + numbers[e] == target) {
                return new int[]{s + 1, e + 1};

            } else if (numbers[s] + numbers[e] > target) {
                e--;

            } else {
                s++;
            }
        }

        return new int[]{};
    }
}