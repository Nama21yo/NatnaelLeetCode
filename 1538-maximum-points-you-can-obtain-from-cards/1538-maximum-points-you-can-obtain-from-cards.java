class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Calculate the total score by picking the first k cards from the left
        int left_score = 0;
        for (int i = 0; i < k; i++) {
            left_score += cardPoints[i];
        }

        // Initialize max_score with the total score from the first k cards
        int max_score = left_score;

        // Now, use a sliding window: remove cards from the left and add cards from the right
        int right_score = 0;
        for (int i = 0; i < k; i++) {
            left_score -= cardPoints[k - 1 - i];  // Remove card from the left end
            right_score += cardPoints[n - 1 - i];  // Add card from the right end
            max_score = Math.max(max_score, left_score + right_score);
        }

        return max_score;
    }
}
