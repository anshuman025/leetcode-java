/*
 * LeetCode 1431 - Kids With the Greatest Number of Candies
 * Link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 *
 * Approach:
 * 1. Find the maximum number of candies among all the kids.
 * 2. Traverse the array again.
 * 3. For each kid, check whether:
 *      currentCandies + extraCandies >= maximumCandies
 * 4. If true, add true to the result list; otherwise, add false.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) (Output List)
 */

import java.util.*;

class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandies = candies[0];

        // Find the maximum candies
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        List<Boolean> result = new ArrayList<>();

        // Check if each kid can have the greatest number of candies
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}

/*
 * Alternative Approach (Using Index-Based Loop)
 *
 * class Solution {
 *
 *     public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
 *
 *         int max = candies[0];
 *
 *         for (int i = 1; i < candies.length; i++) {
 *             if (candies[i] > max) {
 *                 max = candies[i];
 *             }
 *         }
 *
 *         List<Boolean> ans = new ArrayList<>();
 *
 *         for (int i = 0; i < candies.length; i++) {
 *             if (candies[i] + extraCandies >= max) {
 *                 ans.add(true);
 *             } else {
 *                 ans.add(false);
 *             }
 *         }
 *
 *         return ans;
 *     }
 * }
 */