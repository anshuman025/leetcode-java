/*
 * LeetCode 3863: Minimum Operations to Sort a String
 * Problem: https://leetcode.com/problems/minimum-operations-to-sort-a-string/
 *
 * Approach: Greedy
 *
 * 1. If the string is already sorted, return 0.
 * 2. If its length is 2 and it is unsorted, return -1.
 * 3. Find the minimum and maximum characters.
 * 4. If the first character is the minimum OR the last
 *    character is the maximum, return 1.
 * 5. If the minimum or maximum appears in the middle,
 *    return 2.
 * 6. Otherwise, return 3.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */

class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        char min = s.charAt(0);
        char max = s.charAt(0);

        // Check whether the string is sorted and find min/max.
        for (int i = 1; i < n; i++) {
            char current = s.charAt(i);

            if (current < s.charAt(i - 1)) {
                sorted = false;
            }

            min = (char) Math.min(min, current);
            max = (char) Math.max(max, current);
        }

        // Case 1: Already sorted.
        if (sorted) {
            return 0;
        }

        // Case 2: Cannot sort an unsorted string of length 2.
        if (n == 2) {
            return -1;
        }

        // Case 3: One operation is sufficient.
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Case 4: Check whether min or max occurs in the middle.
        for (int i = 1; i < n - 1; i++) {
            char current = s.charAt(i);

            if (current == min || current == max) {
                return 2;
            }
        }

        // Case 5: All other unsorted strings need 3 operations.
        return 3;
    }
}