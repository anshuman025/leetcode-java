/*
 * LeetCode 350 - Intersection of Two Arrays II
 *
 * Link:
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Approach:
 *
 * Use a HashMap to store the frequency of each number
 * in nums1.
 *
 * Then traverse nums2.
 *
 * If the current number has a frequency greater than 0:
 *     - Add it to the result.
 *     - Decrease its frequency by 1.
 *
 * This allows duplicates to be included according to how
 * many times the number appears in both arrays.
 *
 * Example:
 *
 * nums1 = [1,2,2,1]
 * nums2 = [2,2]
 *
 * Map:
 * 1 → 2
 * 2 → 2
 *
 * First 2:
 *     Add 2 → frequency becomes 1
 *
 * Second 2:
 *     Add 2 → frequency becomes 0
 *
 * Result:
 * [2,2]
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        // Store the frequency of each number in nums1.
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check nums2 against the stored frequencies.
        for (int num : nums2) {

            if (map.getOrDefault(num, 0) > 0) {

                list.add(num);

                // Use one occurrence.
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert List<Integer> to int[].
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}