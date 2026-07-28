/*
 * LeetCode 1512 - Number of Good Pairs
 * Link: https://leetcode.com/problems/number-of-good-pairs/
 *
 * Approach (Brute Force):
 * 1. Traverse the array using two nested loops.
 * 2. For every index i, compare it with all indices j where j > i.
 * 3. If nums[i] == nums[j], increment the good pair count.
 * 4. Return the total number of good pairs.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */

class Solution {

    public int numIdenticalPairs(int[] nums) {

        int goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    goodPairs++;
                }
            }
        }

        return goodPairs;
    }
}

/*
 * Optimized Approach:
 *
 * This problem can be solved in O(n) time using a HashMap
 * to store the frequency of each number.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * (Will be added after covering the HashMap topic.)
 */