/**
 * LeetCode 1920
 * https://leetcode.com/problems/build-array-from-permutation/
 * Build Array from Permutation
 *
 * Difficulty: Easy
 *
 * Approach:
 * Create a new array and fill it using nums[nums[i]].
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


 class Solution {
    public int[] buildArray(int[] nums) {
        int[]ans = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            ans[i] =  nums[nums[i]];
        }
        return ans;
    }
}



