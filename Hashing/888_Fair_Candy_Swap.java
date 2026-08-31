/*
 * LeetCode 888 - Fair Candy Swap
 *
 * Link:
 * https://leetcode.com/problems/fair-candy-swap/
 *
 * Approach:
 *
 * First calculate the total candies Alice and Bob have.
 *
 * Let:
 *     aTotal = Alice's total
 *     bTotal = Bob's total
 *
 * We calculate:
 *
 *     diff = (aTotal - bTotal) / 2
 *
 * If Alice gives x candies and Bob gives y candies,
 * their totals become equal when:
 *
 *     x - y = diff
 *
 * Therefore:
 *
 *     y = x - diff
 *
 * Store all of Bob's candy sizes in a HashSet so we can
 * quickly check whether Bob has the required candy.
 *
 * For every candy x belonging to Alice:
 *
 *     Calculate y = x - diff
 *
 *     If Bob has y, return [x, y].
 *
 * Example:
 *
 * Alice = [1,1]
 * Bob   = [2,2]
 *
 * Alice total = 2
 * Bob total   = 4
 *
 * diff = (2 - 4) / 2
 *      = -1
 *
 * For Alice's x = 1:
 *
 * y = 1 - (-1)
 *   = 2
 *
 * Bob has 2, so return [1,2].
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(m)
 */

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aTotal = 0;
        int bTotal = 0;

        // Calculate Alice's total.
        for (int candy : aliceSizes) {
            aTotal += candy;
        }

        // Calculate Bob's total.
        for (int candy : bobSizes) {
            bTotal += candy;
        }

        // Difference between the values of the candies
        // that Alice and Bob need to exchange.
        int diff = (aTotal - bTotal) / 2;

        // Store Bob's candy sizes for quick lookup.
        Set<Integer> bob = new HashSet<>();

        for (int candy : bobSizes) {
            bob.add(candy);
        }

        // Try each candy Alice could give.
        for (int x : aliceSizes) {

            int y = x - diff;

            // Check if Bob has the required candy.
            if (bob.contains(y)) {
                return new int[]{x, y};
            }
        }

        return new int[]{};
    }
}
