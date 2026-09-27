/*
 * LeetCode 1190 - Reverse Substrings Between Each Pair of Parentheses
 *
 * Problem:
 * Reverse the strings inside each pair of matching parentheses,
 * starting from the innermost pair. Return the final string without
 * any parentheses.
 *
 * LeetCode:
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 *
 * Approach:
 * Brute Force
 *
 * Repeatedly find the innermost pair of parentheses, reverse the
 * substring inside it, replace the complete pair with the reversed
 * substring, and continue until no parentheses remain.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public String reverseParentheses(String s) {
        while (s.contains("(")) {
            int open = -1;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    open = i;
                }
            }

            int close = s.indexOf(')', open);

            String part = s.substring(open + 1, close);
            String reversed = new StringBuilder(part).reverse().toString();

            s = s.substring(0, open) + reversed + s.substring(close + 1);
        }

        return s;
    }
}