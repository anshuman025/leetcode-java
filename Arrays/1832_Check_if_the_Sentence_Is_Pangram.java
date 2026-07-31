/*
LeetCode 1832 - Check if the Sentence Is Pangram

Approach:
1. If the string length is less than 26, return false.
2. Iterate from 'a' to 'z'.
3. Use indexOf() to check if each alphabet exists.
4. If any alphabet is missing, return false.
5. If all alphabets are found, return true.

Time Complexity: O(26 × n) = O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean checkIfPangram(String s) {

        if (s.length() < 26) {
            return false;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (s.indexOf(ch) == -1) {
                return false;
            }
        }

        return true;
    }
}
