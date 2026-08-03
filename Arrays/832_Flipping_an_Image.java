/*
 * LeetCode 832 - Flipping an Image
 * Link: https://leetcode.com/problems/flipping-an-image/
 *
 * ----------------------------------------------------
 * Approach 1: Flip First, Then Invert
 * ----------------------------------------------------
 *
 * Idea:
 * - Reverse every row.
 * - Traverse the row again.
 * - Change 1 -> 0 and 0 -> 1.
 *
 * Time: O(m × n)
 * Space: O(1)
 *
 * ----------------------------------------------------
 * Approach 2: Flip + Invert Together (One Pass)
 * ----------------------------------------------------
 *
 * Idea:
 * - Use two pointers to reverse the row.
 * - While swapping, invert both values using XOR (^1).
 * - This combines both operations into a single traversal.
 *
 * Time: O(m × n)
 * Space: O(1)
 */

class Solution {

    // ---------- Approach 1 : Flip First, Then Invert ----------

    void flip(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public int[][] flipAndInvertImage(int[][] image) {

        for (int[] row : image) {

            flip(row);

            for (int i = 0; i < row.length; i++) {

                if (row[i] == 1) {
                    row[i] = 0;
                } else {
                    row[i] = 1;
                }
            }
        }

        return image;
    }


    // ---------- Approach 2 : Flip + Invert Together ----------

    public int[][] flipAndInvertImage(int[][] image) {

        for (int[] row : image) {

            int left = 0;
            int right = row.length - 1;

            while (left <= right) {

                int temp = row[left] ^ 1;
                row[left] = row[right] ^ 1;
                row[right] = temp;

                left++;
                right--;
            }
        }

        return image;
    }

}