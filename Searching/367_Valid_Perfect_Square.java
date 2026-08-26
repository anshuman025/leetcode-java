/*
 * LeetCode 367 - Valid Perfect Square
 *
 * Link:
 * https://leetcode.com/problems/valid-perfect-square/
 *
 * Approach:
 *
 * Use Binary Search to find whether there is an integer
 * whose square is exactly equal to num.
 *
 * If mid * mid == num:
 *     Perfect square found.
 *
 * If mid * mid > num:
 *     mid is too large, search left.
 *
 * If mid * mid < num:
 *     mid is too small, search right.
 *
 * long is used to prevent integer overflow.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Binary Search.
 */

class Solution {
    public boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }

        long s = 1;
        long e = num / 2;

        while (s <= e) {

            long mid = s + (e - s) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;

            } else if (square > num) {
                e = mid - 1;

            } else {
                s = mid + 1;
            }
        }

        return false;
    }
}