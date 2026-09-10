/*
 * LeetCode 754 - Reach a Number
 * Link: https://leetcode.com/problems/reach-a-number/
 *
 * Approach: Greedy / Mathematical
 *
 * On move k, we can move either +k or -k.
 * First, keep adding steps until the total distance
 * reaches or passes the target.
 *
 * If the difference between the total and target is
 * even, we can change some + moves to - moves and
 * reach the target exactly.
 *
 * Time Complexity: O(sqrt(target))
 * Space Complexity: O(1)
 */

class Solution {
    public int reachNumber(int target) {

        target = Math.abs(target);

        int steps = 0;
        int sum = 0;

        while (sum < target || (sum - target) % 2 != 0) {
            steps++;
            sum += steps;
        }

        return steps;
    }
}