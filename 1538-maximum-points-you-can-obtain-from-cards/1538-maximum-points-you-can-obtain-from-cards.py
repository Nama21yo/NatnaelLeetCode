class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        left_score = 0
        max_score = 0
        right_score = 0
        for i in range(k):
            left_score += cardPoints[i]
        
        max_score = left_score
        right = len(cardPoints) - 1

        for j in range(k - 1, -1, -1):
            left_score -= cardPoints[j]
            right_score += cardPoints[right]
            right -= 1

            max_score = max(max_score, left_score + right_score)
        

        return max_score
        