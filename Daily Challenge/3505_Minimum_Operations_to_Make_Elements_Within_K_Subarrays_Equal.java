/*
 * Problem: 3505. Minimum Operations to Make Elements Within K Subarrays Equal
 * LeetCode: https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/
 *
 * Approach: Sliding Window + Fenwick Tree + Dynamic Programming
 *
 * Time Complexity: O(n log n + n * k)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

class Solution {

    static class FenwickTree {
        int n;
        int[] count;
        long[] sum;

        FenwickTree(int n) {
            this.n = n;
            count = new int[n + 1];
            sum = new long[n + 1];
        }

        void update(int index, int countDelta, long sumDelta) {
            for (int i = index; i <= n; i += i & -i) {
                count[i] += countDelta;
                sum[i] += sumDelta;
            }
        }

        int queryCount(int index) {
            int result = 0;

            for (int i = index; i > 0; i -= i & -i) {
                result += count[i];
            }

            return result;
        }

        long querySum(int index) {
            long result = 0;

            for (int i = index; i > 0; i -= i & -i) {
                result += sum[i];
            }

            return result;
        }

        int findKth(int k) {
            int index = 0;

            for (int bit = Integer.highestOneBit(n);
                 bit != 0; bit >>= 1) {

                int next = index + bit;

                if (next <= n && count[next] < k) {
                    index = next;
                    k -= count[next];
                }
            }

            return index + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int size = 0;

        for (int num : sorted) {
            if (size == 0 || sorted[size - 1] != num) {
                sorted[size++] = num;
            }
        }

        int[] compressed = new int[n];

        for (int i = 0; i < n; i++) {
            compressed[i] =
                    Arrays.binarySearch(sorted, 0, size, nums[i]) + 1;
        }

        FenwickTree bit = new FenwickTree(size);

        long[] windowCost = new long[n - x + 1];
        long windowSum = 0;

        for (int i = 0; i < x; i++) {
            bit.update(compressed[i], 1, nums[i]);
            windowSum += nums[i];
        }

        int medianPosition = (x + 1) / 2;

        for (int start = 0; start <= n - x; start++) {
            int medianIndex = bit.findKth(medianPosition);
            int median = sorted[medianIndex - 1];

            int leftCount = bit.queryCount(medianIndex);
            long leftSum = bit.querySum(medianIndex);

            long rightCount = x - leftCount;
            long rightSum = windowSum - leftSum;

            windowCost[start] =
                    (long) median * leftCount - leftSum
                            + rightSum - (long) median * rightCount;

            if (start < n - x) {
                bit.update(
                        compressed[start],
                        -1,
                        -(long) nums[start]
                );

                bit.update(
                        compressed[start + x],
                        1,
                        nums[start + x]
                );

                windowSum += (long) nums[start + x] - nums[start];
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int used = 1; used <= k; used++) {
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {
                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != INF) {
                    long cost = prev[i - x] + windowCost[i - x];
                    curr[i] = Math.min(curr[i], cost);
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}