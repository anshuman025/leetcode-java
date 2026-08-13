/*
 * LeetCode 26 - Remove Duplicates from Sorted Array
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * ==========================================================
 * Approach 1 - i = 0
 * ==========================================================
 *
 * i → index of the last unique element
 * j → scans the array
 *
 * When a new unique number is found:
 * 1. Move i forward
 * 2. Put the new number at nums[i]
 *
 * Time: O(n)
 * Space: O(1)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;

        int i = 0;

        for(int j = 1; j < n ;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;


    }
}


/*
 * ==========================================================
 * Approach 2 - i = 1
 * ==========================================================
 *
 * i → next position where a unique number should be placed
 * j → scans the array
 *
 * When a new unique number is found:
 * 1. Put the number at nums[i]
 * 2. Move i forward
 *
 * Time: O(n)
 * Space: O(1)
 */

class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int i = 1;

        for (int j = 1; j < n; j++) {

            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}