/*
 * LeetCode 1672 - Richest Customer Wealth
 * Link: https://leetcode.com/problems/richest-customer-wealth/
 *
 * Time Complexity: O(m × n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maximumWealth(int[][] accounts) {

        int max = 0;

        for (int i = 0; i < accounts.length; i++) {

            int sum = 0;

            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    /*
    // ----------------------------
    // Approach 2: Enhanced For Loop
    // Time: O(m × n)
    // Space: O(1)
    // ----------------------------

    public int maximumWealth(int[][] accounts) {

        int max = 0;

        for (int[] customer : accounts) {

            int sum = 0;

            for (int money : customer) {
                sum += money;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
    */
}