/*
 * LeetCode 2778 - Sum of Squares of Special Elements
 *
 * Difficulty: Easy
 * Topic: Array
 *
 * Problem:
 * Given a 1-indexed integer array nums of length n, an element
 * nums[i] is special if its 1-based index i divides n.
 *
 * Return the sum of squares of all special elements.
 *
 * LeetCode:
 * https://leetcode.com/problems/sum-of-squares-of-special-elements/
 *
 * Example:
 * Input: nums = [1, 2, 3, 4]
 * Output: 21
 *
 * Explanation:
 * The array length is 4.
 * Special indices are 1, 2, and 4 because they divide 4.
 *
 * Sum = nums[0]^2 + nums[1]^2 + nums[3]^2
 *     = 1^2 + 2^2 + 4^2
 *     = 21
 *
 * Approach:
 * 1. Find the length n of the array.
 * 2. Traverse the array using a 0-based index i.
 * 3. Convert i to its 1-based index using i + 1.
 * 4. If n % (i + 1) == 0, the element is special.
 * 5. Add the square of that element to the answer.
 * 6. Return the final sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                ans += nums[i] * nums[i];
            }
        }

        return ans;
    }
}