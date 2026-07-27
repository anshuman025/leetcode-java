/*
 * LeetCode 1470 - Shuffle the Array
 * Link: https://leetcode.com/problems/shuffle-the-array/
 *
 * Approach:
 * 1. Create a new array of size 2 * n.
 * 2. Traverse only the first half of the array (0 to n - 1).
 * 3. Place the x elements at even indices (2 * i).
 * 4. Place the corresponding y elements at odd indices (2 * i + 1).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] arr = new int[2 * n];

        for (int i = 0; i < n; i++) {
            arr[2 * i] = nums[i];
            arr[2 * i + 1] = nums[i + n];
        }

        return arr;
    }
}

/*
 * Alternative Approach (Odd-Even Index Mapping)
 *
 * class Solution {
 *     public int[] shuffle(int[] nums, int n) {
 *
 *         int len = nums.length;
 *         int[] ans = new int[len];
 *
 *         for (int i = 0; i < len; i++) {
 *             if (i % 2 == 0) {
 *                 ans[i] = nums[i / 2];
 *             } else {
 *                 ans[i] = nums[n + (i / 2)];
 *             }
 *         }
 *
 *         return ans;
 *     }
 * }
 */