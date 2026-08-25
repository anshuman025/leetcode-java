/*
 * LeetCode 69 - Sqrt(x)
 *
 * Link:
 * https://leetcode.com/problems/sqrtx/
 *
 * ----------------------------------------------------
 * Approach 1: Brute Force
 *
 * Check every integer starting from 1.
 * Find the largest integer whose square is less than
 * or equal to x.
 *
 * Time Complexity: O(x)
 * Space Complexity: O(1)
 *
 * ----------------------------------------------------
 * Approach 2: Binary Search
 *
 * Search for the largest integer whose square is
 * less than or equal to x.
 *
 * If mid * mid == x:
 *     Exact square root found.
 *
 * If mid * mid < x:
 *     mid is a valid answer, so save it and search
 *     for a larger value.
 *
 * If mid * mid > x:
 *     mid is too large, so search on the left.
 *
 * long is used for multiplication to avoid
 * integer overflow.
 *
 * Time Complexity: O(log x)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Binary Search is the optimized solution.
 * ----------------------------------------------------
 */

class Solution {

    // Approach 1: Brute Force

    public int mySqrtBruteForce(int x) {

        int answer = 0;

        for (int i = 1; i <= x; i++) {

            if ((long) i * i <= x) {
                answer = i;
            } else {
                break;
            }
        }

        return answer;
    }


    // Approach 2: Binary Search

    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int start = 1;
        int end = x;
        int answer = 0;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if ((long) mid * mid == x) {
                return mid;

            } else if ((long) mid * mid < x) {

                answer = mid;
                start = mid + 1;

            } else {

                end = mid - 1;
            }
        }

        return answer;
    }
}