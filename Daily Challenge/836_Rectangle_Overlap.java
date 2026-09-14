/*
 * LeetCode 836 - Rectangle Overlap
 * Link: https://leetcode.com/problems/rectangle-overlap/
 *
 * Approach:
 * Check whether the two rectangles have a positive-width
 * and positive-height intersection.
 *
 * Strict inequalities are used because rectangles that only
 * touch at an edge or corner do not overlap.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] &&
                rec2[0] < rec1[2] &&
                rec1[1] < rec2[3] &&
                rec2[1] < rec1[3];
    }
}