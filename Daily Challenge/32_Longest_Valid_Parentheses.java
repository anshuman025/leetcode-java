/*
 * LeetCode 32 - Longest Valid Parentheses
 *
 * Problem:
 * Given a string containing '(' and ')', return the length
 * of the longest valid parentheses substring.
 *
 * LeetCode:
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Approach:
 * Use a Stack to store indices.
 *
 * - Push -1 as the initial boundary.
 * - Store indices of opening brackets.
 * - When ')' is found, pop the matching '('.
 * - If the stack becomes empty, push the current index
 *   as the new boundary.
 * - Otherwise, calculate the valid length using:
 *   current index - stack.peek()
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }
}
