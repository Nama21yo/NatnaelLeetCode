class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int max_width = 0;
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                max_width = Math.max(max_width, i - stack.peek());
                stack.pop();
            }
        }

        return max_width;
    }
}