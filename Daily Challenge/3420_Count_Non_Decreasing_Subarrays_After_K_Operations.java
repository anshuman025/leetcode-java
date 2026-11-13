/*
 * Problem: 3420. Count Non-Decreasing Subarrays After K Operations
 * LeetCode: https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/
 *
 * Approach: Sliding Window + Monotonic Deque
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    static class Pair {
        int value;
        int count;

        Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        long ans = 0;
        long cost = 0;

        Deque<Pair> dq = new ArrayDeque<>();

        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Maintain the monotonic deque.
            while (!dq.isEmpty() && dq.peekLast().value < num) {

                Pair p = dq.removeLast();

                count += p.count;

                cost += (long) (num - p.value) * p.count;
            }

            dq.addLast(new Pair(num, count));

            // Shrink the window if operations exceed k.
            while (cost > k) {

                Pair p = dq.removeFirst();

                cost -= (long) (p.value - nums[right]);

                right--;

                if (p.count > 1) {
                    dq.addFirst(new Pair(p.value, p.count - 1));
                }
            }

            // Count all valid subarrays ending at right.
            ans += right - i + 1;
        }

        return ans;
    }
}