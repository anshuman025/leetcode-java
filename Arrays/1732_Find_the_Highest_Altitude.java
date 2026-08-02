/*
 * LeetCode 1732 - Find the Highest Altitude
 * Link: https://leetcode.com/problems/find-the-highest-altitude/
 *
 * ----------------------------------------------------
 * Approach 1: Running Altitude (Optimal)
 * ----------------------------------------------------
 *
 * Idea:
 * - Start from altitude 0.
 * - Keep updating the current altitude using each gain.
 * - After every update, check if it's the highest altitude so far.
 * - Return the highest altitude.
 *
 * Time: O(n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Approach 2: Prefix Sum Array
 * ----------------------------------------------------
 *
 * Idea:
 * - Create a new array to store every altitude reached.
 * - First altitude is always 0.
 * - Build the altitude array using the gain array.
 * - Traverse the altitude array and find the maximum altitude.
 *
 * Time: O(n)
 * Space: O(n)
 */

class Solution {

    // ---------- Approach 1 : Running Altitude ----------

    public int largestAltitude(int[] gain) {

        int altitude = 0;
        int maxAltitude = 0;

        for (int currentGain : gain) {

            altitude += currentGain;

            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }


    // ---------- Approach 2 : Prefix Sum Array ----------

    public int largestAltitude(int[] gain) {

        int n = gain.length;
        int[] altitude = new int[n + 1];

        for (int i = 0; i < n; i++) {
            altitude[i + 1] = altitude[i] + gain[i];
        }

        int maxAltitude = 0;

        for (int currentAltitude : altitude) {
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }

}