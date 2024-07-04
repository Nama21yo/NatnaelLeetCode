class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        
        // Calculate the initial sum of the first k cards from the left
        for(int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        
        // Initialize maxSum with the initial leftSum
        int maxSum = leftSum;
        
        // Initialize the right index to point to the last card
        int rightIndex = cardPoints.length - 1;
        
        // Iterate k times to consider taking cards from the right
        for(int j = k - 1; j >= 0; j--)  {
            leftSum -= cardPoints[j]; // Remove the card from the left sum
            rightSum += cardPoints[rightIndex]; // Add the card to the right sum
            rightIndex--; // Move the right index to the left
            
            // Update maxSum with the maximum value of the current sum
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        
        return maxSum;
    }
}
