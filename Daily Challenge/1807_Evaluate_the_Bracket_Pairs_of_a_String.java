/*
 * LeetCode 1807 - Evaluate the Bracket Pairs of a String
 *
 * Problem:
 * Given a string containing bracket pairs and a list of key-value pairs,
 * replace every bracketed key with its corresponding value.
 * If a key is not present in the knowledge list, replace it with "?".
 *
 * LeetCode:
 * https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
 *
 * Approach:
 * 1. Store all key-value pairs in a HashMap.
 * 2. Traverse the string from left to right.
 * 3. If the current character is normal, add it to the answer.
 * 4. If '(' is found, find the corresponding ')'.
 * 5. Extract the key between the brackets.
 * 6. Use HashMap to find its value.
 * 7. If the key does not exist, append "?".
 *
 * Data Structures:
 * - HashMap<String, String>
 * - StringBuilder
 *
 * Time Complexity:
 * O(n + k)
 *
 * Space Complexity:
 * O(k)
 *
 * Where:
 * n = length of the string
 * k = number of key-value pairs in knowledge
 */

import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) != '(') {
                ans.append(s.charAt(i));
                i++;
            } else {
                int start = i + 1;

                while (s.charAt(i) != ')') {
                    i++;
                }

                String key = s.substring(start, i);

                ans.append(map.getOrDefault(key, "?"));

                i++;
            }
        }

        return ans.toString();
    }
}