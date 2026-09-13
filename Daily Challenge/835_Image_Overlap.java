/*
 * LeetCode 835 - Image Overlap
 * Link: https://leetcode.com/problems/image-overlap/
 *
 * Approach: Brute Force
 *
 * Try every possible shift of img1 over img2.
 * For each shift, count how many positions contain 1 in both images.
 * Keep track of the maximum overlap.
 *
 * Time Complexity: O(n^4)
 * Space Complexity: O(1)
 */

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for (int dr = -(n - 1); dr <= n - 1; dr++) {
            for (int dc = -(n - 1); dc <= n - 1; dc++) {

                int overlap = 0;

                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {

                        int r2 = r + dr;
                        int c2 = c + dc;

                        if (r2 >= 0 && r2 < n &&
                                c2 >= 0 && c2 < n &&
                                img1[r][c] == 1 &&
                                img2[r2][c2] == 1) {

                            overlap++;
                        }
                    }
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }
}
