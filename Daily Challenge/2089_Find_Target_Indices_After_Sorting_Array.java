

/*
 * LeetCode 2089: Find Target Indices After Sorting Array
 * Problem: https://leetcode.com/problems/find-target-indices-after-sorting-array/
 *
 * Approach:
 * 1. Sort the array in non-decreasing order.
 * 2. Traverse the sorted array.
 * 3. Add every index where nums[i] == target to the result list.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n) for the result list
 */

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }
}