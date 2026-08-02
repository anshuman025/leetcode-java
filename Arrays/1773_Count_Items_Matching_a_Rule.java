/*
 * LeetCode 1773 - Count Items Matching a Rule
 * Link: https://leetcode.com/problems/count-items-matching-a-rule/
 *
 * Approach 1: Simple For Loop
 * 1. Convert the given ruleKey into its corresponding column index.
 *    - type  -> 0
 *    - color -> 1
 *    - name  -> 2
 * 2. Traverse all the items.
 * 3. Extract the current item (row).
 * 4. Compare the value at the required column with ruleValue.
 * 5. If they match, increment the count.
 * 6. Return the total count.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.List;

class Solution {

    // -----------------------------------
    // Approach 1: Simple For Loop
    // -----------------------------------

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int index = 0;

        if (ruleKey.equals("type")) {
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        } else {
            index = 2;
        }

        int count = 0;

        for (int i = 0; i < items.size(); i++) {

            List<String> item = items.get(i);

            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }


    // -----------------------------------
    // Approach 2: Enhanced For-Each Loop
    // -----------------------------------

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int index = 0;

        if (ruleKey.equals("type")) {
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        } else {
            index = 2;
        }

        int count = 0;

        for (List<String> item : items) {

            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }

}