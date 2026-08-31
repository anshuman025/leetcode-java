/*
 * LeetCode 1346 - Check If N and Its Double Exist
 *
 * Link:
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 *
 * Approach:
 *
 * Use a HashSet to store the numbers we have already seen.
 *
 * For every number num:
 *
 * 1. Check if 2 * num already exists in the Set.
 *    If yes, we found a valid pair.
 *
 * 2. Check if num is even and num / 2 already exists.
 *    This handles the case where the current number is
 *    the double of a number we have already seen.
 *
 * 3. If neither condition is true, add num to the Set
 *    and continue.
 *
 * Example:
 *
 * arr = [10, 2, 5, 3]
 *
 * When num = 5:
 *
 *     5 * 2 = 10
 *
 * 10 is already in the Set, so return true.
 *
 * We add the current number only after checking both
 * conditions so that the same element is not used twice.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean checkIfExist(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {

            if (set.contains(num * 2)) {
                return true;
            }

            if (num % 2 == 0 && set.contains(num / 2)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}