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

/*
 * Approach:
        * 1. Create a copy of the original array.
 * 2. Sort the copied array.
        * 3. Store the first occurrence (index) of each number in a HashMap.
        *    - The first index in the sorted array represents how many numbers are
 *      smaller than the current number.
 * 4. Traverse the original array.
        * 5. Use the HashMap to get the answer for each element.
        * 6. Store the answer in the result array.
 *
         * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

         import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] sorted = Arrays.copyOf(nums, nums.length);

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sorted.length; i++) {

            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], i);
            }
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }

        return result;
    }
}