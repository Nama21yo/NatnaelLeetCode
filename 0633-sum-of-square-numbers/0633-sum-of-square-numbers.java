class Solution {
    public boolean judgeSquareSum(int c) {
        // Negative number cannot be the sum of two squares
        if(c < 0) return false;
        
        // Initialize two pointers
        long left = 0;
        long right = (int) Math.sqrt(c);
        
        // Use a two-pointer technique to find if two numbers' squares sum up to 'c'
        while(left <= right) {
            long sum = left * left + right * right;
            
            // If the sum of squares is equal to 'c', return true
            if(sum == c) {
                return true;
            // If the sum is less than 'c', move the left pointer to the right
            } else if(sum < c) {
                left++;
            // If the sum is greater than 'c', move the right pointer to the left
            } else {
                right--;
            }
        }
        // If no such pair is found, return false
        return false;
    }
}
