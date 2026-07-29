/*
 * LeetCode 1365 - How Many Numbers Are Smaller Than the Current Number
 * Link: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * Approach:
 * 1. Create a result array of the same size as the input array.
 * 2. Traverse the array using an outer loop.
 * 3. For each element, compare it with every other element using an inner loop.
 * 4. Count how many elements are smaller than the current element.
 * 5. Store the count in the corresponding index of the result array.
 * 6. Return the result array.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(n) (Result Array)
 */

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = 0; j < nums.length; j++) {

                if (nums[j] < nums[i]) {
                    count++;
                }

            }

            result[i] = count;
        }

        return result;
    }
}
