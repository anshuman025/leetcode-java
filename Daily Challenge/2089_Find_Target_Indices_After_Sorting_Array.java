

/*
 * LeetCode 2089: Find Target Indices After Sorting Array
 * Problem: https://leetcode.com/problems/find-target-indices-after-sorting-array/
 *
 * APPROACH 1: Brute Force
 * 1. Sort the array.
 * 2. Traverse the array and collect indices equal to target.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n) for the result list (excluding sorting space)
 *
 * APPROACH 2: Optimized
 * 1. Count elements smaller than target.
 * 2. Count occurrences of target.
 * 3. Generate the consecutive target indices.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1), excluding the result list.
 */

class Solution {

    // Approach 1: Brute Force — Sort and Search
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

    // Approach 2: Optimized — Count Smaller and Equal Elements
    public List<Integer> targetIndicesOptimized(int[] nums, int target) {
        int smaller = 0;
        int equal = 0;

        for (int num : nums) {
            if (num < target) {
                smaller++;
            } else if (num == target) {
                equal++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = smaller; i < smaller + equal; i++) {
            result.add(i);
        }

        return result;
    }
}