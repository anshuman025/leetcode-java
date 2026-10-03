/*
 * LeetCode 20 - Valid Parentheses
 *
 * Problem:
 * Given a string containing '(', ')', '{', '}', '[' and ']',
 * determine if the brackets are valid.
 *
 * LeetCode:
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Approach:
 * Use a Stack.
 *
 * 1. Push every opening bracket into the stack.
 * 2. For a closing bracket, check if the stack is empty.
 * 3. Pop the top bracket and check if it matches.
 * 4. At the end, the stack must be empty.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> S = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                S.push(c);
            }else{
                if(S.isEmpty()){
                    return false;
                }

                char top = S.pop();

                if(c == ')' && top != '('){
                    return false;
                }

                if(c == ']' && top != '['){
                    return false;
                }

                if(c == '}' && top != '{'){
                    return false;
                }
            }
        }

        return S.isEmpty();
    }
}