/*
 * LeetCode 1346 - Check If N and Its Double Exist
 *
 * Link:
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 *
 * ----------------------------------------------------
 * Approach 1: Sorting + Binary Search
 *
 * First sort the array.
 *
 * For every element arr[i]:
 *
 *     target = arr[i] * 2
 *
 * Then use Binary Search to check whether target exists
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
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) extra
 *
 * ----------------------------------------------------
 * Approach 2: Sorting + Binary Search using Helper
 *
 * The Binary Search logic is moved into a separate
 * helper function.
 *
 * The main method calculates the target and calls
 * binarySearch() to search for it.
 *
 * This makes the main method cleaner and keeps the
 * Binary Search logic separate.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) extra
 */

// ----------------------------------------------------
// Approach 1: Binary Search directly
// ----------------------------------------------------

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


/*
 * ----------------------------------------------------
 * Approach 2: Binary Search using Helper Function
 * ----------------------------------------------------
 *
 * Same Binary Search logic as Approach 1, but the
 * searching part is moved into a helper function.
 *
 * The main method calculates the target and calls
 * binarySearch() to search for it.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) extra
 */

class Solution {
    public boolean checkIfExist(int[] arr) {

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            int target = arr[i] * 2;

            if (binarySearch(arr, target, i)) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] arr, int target, int i) {

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

        return false;
    }
}