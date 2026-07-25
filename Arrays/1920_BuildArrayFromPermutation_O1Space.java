/*
 * Approach 2: In-Place Encoding (O(1) Extra Space)
 * https://leetcode.com/problems/build-array-from-permutation
 * Intuition:
 * Instead of creating a new array, we store both the original value
 * and the new value in the same array element using mathematical encoding.
 *
 * Since every value in nums is in the range [0, n-1], we can safely
 * encode two numbers into one integer.
 *
 * Encoding:
 * nums[i] = originalValue + (newValue * n)
 *
 * Here:
 * - originalValue = nums[i] % n
 * - newValue = nums[nums[i]] % n
 *
 * After encoding all elements, divide each element by n to extract
 * the newly computed value.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


class Solution {
    public int[] buildArray(int[] nums) {

        int n = nums.length;

        for(int i = 0; i< n; i++){

            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }
        for(int i = 0; i< n; i++){
            nums[i] = nums[i] / n;
        }
        return nums;
    }
}