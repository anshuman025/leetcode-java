/*
 * LeetCode 1854 - Maximum Population Year
 * Link: https://leetcode.com/problems/maximum-population-year/
 *
 * ----------------------------------------------------
 * Approach 1: Population Counting
 * ----------------------------------------------------
 *
 * Idea:
 * - Create an array to store the population for every year
 *   from 1950 to 2050.
 * - For each person, increment every year they were alive
 *   (birth to death - 1).
 * - Traverse the population array to find the maximum
 *   population.
 * - If two years have the same maximum population,
 *   keep the first one since the question asks for
 *   the earliest year.
 *
 * Time: O(n × 101) ≈ O(n)
 * Space: O(101) ≈ O(1)
 */

class Solution {

    public int maximumPopulation(int[][] logs) {

        int[] population = new int[101];

        // Count population for each year
        for (int[] log : logs) {

            int birth = log[0];
            int death = log[1];

            for (int year = birth; year < death; year++) {
                population[year - 1950]++;
            }
        }

        int maxPopulation = 0;
        int answerYear = 1950;

        // Find the earliest year with maximum population
        for (int i = 0; i < population.length; i++) {

            if (population[i] > maxPopulation) {
                maxPopulation = population[i];
                answerYear = i + 1950;
            }
        }

        return answerYear;
    }
}