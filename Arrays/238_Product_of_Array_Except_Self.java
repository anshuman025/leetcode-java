/*
 * LeetCode 238 - Product of Array Except Self
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 *
 * Approach:
 *
 * First pass:
 * Store the product of all elements to the LEFT of each index.
 *
 * Second pass:
 * Traverse from right to left and multiply the LEFT product
 * by the product of all elements to the RIGHT.
 *
 * Example:
 *
 * nums   = [1, 2, 3, 4]
 * result = [24, 12, 8, 6]
 *
 * Time: O(n)
 * Extra Space: O(1)
 *
 * The result array is required as the output, so it is not
 * counted as extra space.
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        int leftP = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = leftP;
            leftP *= nums[i];
        }

        int rightP = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= rightP;
            rightP *= nums[i];
        }

        return res;
    }
}