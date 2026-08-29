/*
 * LeetCode 349 - Intersection of Two Arrays
 *
 * Link:
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Approach:
 *
 * Use a HashSet to store the unique elements of nums1.
 *
 * Then traverse nums2 and check whether each number exists
 * in the HashSet.
 *
 * If it exists:
 *     - Add it to the result list.
 *     - Remove it from the HashSet so it cannot be added again.
 *
 * Example:
 *
 * nums1 = [1,2,2,1]
 * nums2 = [2,2]
 *
 * HashSet after nums1:
 * {1,2}
 *
 * First 2:
 *     Found → add 2 → remove 2
 *
 * Second 2:
 *     Not found → don't add
 *
 * Result:
 * [2]
 *
 * The HashSet automatically removes duplicates from nums1,
 * and removing an element after finding it prevents duplicates
 * from being added from nums2.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 *
 * n = length of nums1
 * m = length of nums2
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> s = new HashSet<>();

        List<Integer> l = new ArrayList<>();

        for (int num : nums1) {
            s.add(num);
        }

        for (int num : nums2) {

            if (s.contains(num)) {

                l.add(num);
                s.remove(num);
            }
        }

        int[] result = new int[l.size()];

        for (int i = 0; i < l.size(); i++) {
            result[i] = l.get(i);
        }

        return result;
    }
}