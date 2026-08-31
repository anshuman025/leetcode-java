/*
 * LeetCode 1346 - Check If N and Its Double Exist
 *
 * Link:
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 *
 * Approach:
 *
 * Sort the array first, then use Binary Search.
 *
 * For every element arr[i]:
 *
 *     target = arr[i] * 2
 *
 * Use Binary Search to check whether target exists
 * at a different index.
 *
 * The condition m != i is important because we need
 * two different elements.
 *
 * Example:
 *
 * arr = [10, 2, 5, 3]
 *
 * After sorting:
 *
 * [2, 3, 5, 10]
 *
 * For 5:
 *
 *     target = 5 * 2
 *            = 10
 *
 * Binary Search finds 10 at a different index,
 * so return true.
 *
 * Special case:
 *
 * arr = [0]
 *
 * 0 * 2 = 0, but there is only one element.
 * Therefore m == i and we don't return true.
 *
 * For [0,0], the two zeros have different indexes,
 * so the answer is true.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) extra
 */

class Solution {
    public boolean checkIfExist(int[] arr) {

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            int target = arr[i] * 2;

            int s = 0;
            int e = arr.length - 1;

            while (s <= e) {

                int m = s + (e - s) / 2;

                if (arr[m] == target && m != i) {
                    return true;

                } else if (arr[m] < target) {
                    s = m + 1;

                } else {
                    e = m - 1;
                }
            }
        }

        return false;
    }
}
