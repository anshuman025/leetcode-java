/*
 * LeetCode 1389 - Create Target Array in the Given Order
 * Link: https://leetcode.com/problems/create-target-array-in-the-given-order/
 *
 * Approach:
 * 1. Create an ArrayList to store the target array.
 * 2. Traverse both nums and index arrays together.
 * 3. Insert nums[i] at position index[i] in the ArrayList.
 *    - If the position is already occupied, ArrayList automatically
 *      shifts the existing elements one position to the right.
 * 4. Create an integer array of the same size as the ArrayList.
 * 5. Copy all elements from the ArrayList into the integer array.
 * 6. Return the target array.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;

class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] target = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }

        return target;
    }
}