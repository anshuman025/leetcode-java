/*
 * LeetCode 1217 - Minimum Cost to Move Chips to The Same Position
 * Link: https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 *
 *
 *
 *
 * Approach:
 *
 * Moving a chip by 2 positions costs 0.
 * Therefore, all odd positions can reach other odd positions for free,
 * and all even positions can reach other even positions for free.
 *
 * Moving between an odd and an even position costs 1.
 *
 * So:
 *
 * - If we move all chips to an odd position,
 *   the cost = number of even-position chips.
 *
 * - If we move all chips to an even position,
 *   the cost = number of odd-position chips.
 *
 * Therefore, the minimum cost is:
 *
 * Math.min(odd, even)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minCostToMoveChips(int[] position) {

        int odd = 0;
        int even = 0;

        for (int pos : position) {

            if (pos % 2 == 0) {
                even++;
            } else odd++;

        }

        return Math.min(odd, even);
    }
}
