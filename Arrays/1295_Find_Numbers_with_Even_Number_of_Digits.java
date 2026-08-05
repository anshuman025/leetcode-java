/*
 * LeetCode 1295 - Find Numbers with Even Number of Digits
 * Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 *
 * ----------------------------------------------------
 * Approach 1: Count Digits Using Division
 * ----------------------------------------------------
 *
 * Idea:
 * - Traverse every number in the array.
 * - Count its digits by repeatedly dividing it by 10.
 * - If the digit count is even, increase the answer.
 *
 * Time: O(n × d)
 *        n = number of elements
 *        d = number of digits in each number
 *
 * Space: O(1)
 */

class Solution {

    public int findNumbers(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (digitCounts(nums[i]) % 2 == 0) {
                count++;
            }

        }

        return count;
    }

    private int digitCounts(int num) {

        int count = 0;

        while (num > 0) {
            num /= 10;
            count++;
        }

        return count;
    }
}


/*
----------------------------------------------------
Approach 2: String Conversion
----------------------------------------------------

Idea:
- Traverse every number in the array.
- Convert each number into a String.
- Check the length of the String.
- If the length is even, increase the answer.

Time: O(n × d)
Space: O(d)
*/

class Solution {

    public int findNumbers(int[] nums) {

        int count = 0;

        for (int num : nums) {

            String s = Integer.toString(num);

            if (s.length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}