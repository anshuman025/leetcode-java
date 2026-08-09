/*
 * LeetCode 1 - Two Sum
 * Link: https://leetcode.com/problems/two-sum/
 *
 * ====================================================
 * Approach 1: Brute Force
 * ====================================================
 *
 * Check every possible pair of numbers.
 *
 * Time: O(n²)
 * Space: O(1)
 */

 class Solution {
     public int[] twoSum(int[] nums, int target) {

       for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                 if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
 }


/*
 * ====================================================
 * Approach 2: HashMap - Optimized
 * ====================================================
 *
 * Store:
 * number -> index
 *
 * For every number:
 * needed = target - nums[i]
 *
 * Check if needed already exists in the HashMap.
 *
 * Time: O(n)
 * Space: O(n)
 */

import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int n = target - nums[i];

            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}