/*
 * LeetCode 278 - First Bad Version
 *
 * Link:
 * https://leetcode.com/problems/first-bad-version/
 *
 * Approach:
 *
 * Use Binary Search to find the first bad version.
 *
 * If mid is bad:
 *     Save mid as a possible answer.
 *     Search on the left for an earlier bad version.
 *
 * If mid is good:
 *     Search on the right.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int s = 1;
        int e = n;
        int ans = -1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (isBadVersion(mid)) {
                ans = mid;
                e = mid - 1;

            } else {
                s = mid + 1;
            }
        }

        return ans;
    }
}