/*
 * LeetCode 744 - Find Smallest Letter Greater Than Target
 *
 * Link:
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * Approach:
 *
 * Use Binary Search to find the smallest letter
 * strictly greater than target.
 *
 * If letters[m] > target:
 *     Store m as a possible answer.
 *     Search left for a smaller valid letter.
 *
 * Otherwise:
 *     Search right.
 *
 * ans = 0 handles the wrap-around case when no letter
 * is greater than target.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int s = 0;
        int e = letters.length - 1;
        int ans = 0;

        while (s <= e) {

            int m = s + (e - s) / 2;

            if (letters[m] > target) {
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return letters[ans];
    }
}