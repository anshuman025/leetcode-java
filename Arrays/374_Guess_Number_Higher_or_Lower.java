/*
 * LeetCode 374 - Guess Number Higher or Lower
 *
 * Link:
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 *
 * Approach:
 *
 * Use Binary Search.
 *
 * The guess() API tells us:
 *
 * -1 -> our guess is higher than the picked number
 *  1 -> our guess is lower than the picked number
 *  0 -> our guess is correct
 *
 * If guess(mid) > 0:
 * The secret number is higher, so search right.
 *
 * If guess(mid) < 0:
 * The secret number is lower, so search left.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Binary Search solution.
 */

public class Solution extends GuessGame {

    public int guessNumber(int n) {

        int s = 1;
        int e = n;

        while (s <= e) {

            int m = s + (e - s) / 2;

            if (guess(m) == 0) {
                return m;

            } else if (guess(m) > 0) {
                s = m + 1;

            } else {
                e = m - 1;
            }
        }

        return -1;
    }
}