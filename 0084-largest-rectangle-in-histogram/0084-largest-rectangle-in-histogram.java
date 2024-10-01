class Solution {
    public int largestRectangleArea(int[] heights) {
        // Stack to store the indices of the heights
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // Pop from the stack when the current height is less than the top of the stack
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];  // Get the height of the bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;  // Calculate the width
                maxArea = Math.max(maxArea, h * width);
            }
            stack.push(i);  // Push current bar index into the stack
        }

        // Compute area for the remaining bars in the stack
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * width);
        }

        return maxArea;
    }
}
