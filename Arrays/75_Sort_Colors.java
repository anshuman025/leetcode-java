/*
 * LeetCode 75 - Sort Colors
 *
 * Link:
 * https://leetcode.com/problems/sort-colors/
 *
 * ----------------------------------------------------
 * Approach 1: Counting
 *
 * Count the number of 0s, 1s, and 2s.
 * Then overwrite the array using those counts.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * ----------------------------------------------------
 * Approach 2: Dutch National Flag
 *
 * Use three pointers:
 *
 * low  -> position for 0
 * mid  -> current element being checked
 * high -> position for 2
 *
 * If nums[mid] == 0:
 * Move it to the left.
 *
 * If nums[mid] == 1:
 * Move mid forward.
 *
 * If nums[mid] == 2:
 * Move it to the right.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Optimization:
 * Fully optimized one-pass solution.
 * ----------------------------------------------------
 */

class Solution {

    // Approach 1: Counting

    public void sortColorsCounting(int[] nums) {

        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : nums) {

            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }

        int i = 0;

        while (zero > 0) {
            nums[i++] = 0;
            zero--;
        }

        while (one > 0) {
            nums[i++] = 1;
            one--;
        }

        while (two > 0) {
            nums[i++] = 2;
            two--;
        }
    }


    // Approach 2: Dutch National Flag

    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                swap(nums, low, mid);
                low++;
                mid++;

            } else if (nums[mid] == 1) {

                mid++;

            } else {

                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}