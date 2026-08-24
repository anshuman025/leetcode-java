/*
 * LeetCode 69 - Sqrt(x)
 *
 * Link:
 * https://leetcode.com/problems/sqrtx/
 *
 * Approach:
 *
 * Check every integer starting from 1.
 * Find the largest integer whose square is less than
 * or equal to x.
 *
 * If the square becomes greater than x, stop searching.
 *
 * long is used for multiplication to avoid integer overflow.
 *
 * Time Complexity: O(x)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Brute-force solution.
 * Binary Search can be used to optimize it.
 */

class Solution {
    public int mySqrt(int x) {

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
}