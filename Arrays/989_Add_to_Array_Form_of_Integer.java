/*
 * LeetCode 989 - Add to Array-Form of Integer
 * Link: https://leetcode.com/problems/add-to-array-form-of-integer/
 *
 * ----------------------------------------------------
 * Approach: Simulate Addition
 * ----------------------------------------------------
 *
 * Idea:
 * - Start from the last digit of the array.
 * - Add the current digit with the last digit of k.
 * - Store only the last digit of the sum.
 * - Carry is added back to k using:
 *      k = (k / 10) + (sum / 10)
 * - If k still has digits left after the array ends,
 *   keep adding them to the answer.
 * - Reverse the list since digits were added from back to front.
 *
 * Time: O(n + d)
 *      n = length of the array
 *      d = number of digits in k
 *
 * Space: O(n)
 */

class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> ans = new ArrayList<>();

        int n = num.length;

        for (int i = n - 1; i >= 0; i--) {

            int sum = num[i] + (k % 10);

            ans.add(sum % 10);

            k = (k / 10) + (sum / 10);
        }

        while (k > 0) {

            ans.add(k % 10);
            k /= 10;
        }

        Collections.reverse(ans);

        return ans;
    }
}