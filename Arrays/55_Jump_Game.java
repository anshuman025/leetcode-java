/*
 * LeetCode 55 - Jump Game
 *
 * Link:
 * https://leetcode.com/problems/jump-game/
 *
 * Approach:
 *
 * Use a Greedy approach.
 *
 * Keep track of the farthest index that can be reached.
 *
 * For every index:
 * 1. Check if the current index is reachable.
 * 2. If i > farthest, we cannot reach this index.
 * 3. Calculate how far we can reach from the current index.
 * 4. Keep the maximum reachable index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Already optimized.
 */

class Solution {
    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > farthest) {
                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }
}
