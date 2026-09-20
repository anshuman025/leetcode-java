/*
 * LeetCode 3498 - Reverse Degree of a String
 * Link: https://leetcode.com/problems/reverse-degree-of-a-string/
 *
 * Approach:
 * For every character, calculate its position in the reversed alphabet.
 * Multiply it by its 1-based position in the string and add to the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int reverseDegree(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int r = 26 - (s.charAt(i) - 'a');
            ans += (i + 1) * r;
        }

        return ans;
    }
}