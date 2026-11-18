class Solution {

    /*
     * Problem: 2914. Minimum Number of Changes to Make Binary String Beautiful
     * Link: https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
     *
     * Approach:
     * Since every substring must have even length, we can partition
     * the string into pairs of consecutive characters.
     *
     * Each pair must contain identical characters (00 or 11).
     * If the characters differ, exactly one change is required.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public int minChanges(String s) {

        int changes = 0;

        for (int i = 0; i < s.length(); i += 2) {

            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }

        return changes;
    }
}