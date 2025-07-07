//avg time O(n), space O(1)

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            /*
             * 

Move the pointers inward: 

    Check if the height at the left pointer is smaller than the height at the right pointer.
    If so, increment the left pointer, moving it towards the center of the container.
    Otherwise, decrement the right pointer, also moving it towards the center.


             */
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}