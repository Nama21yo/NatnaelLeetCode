class Solution:
    def maxScore(self, s: str) -> int:
        zero_count = 0
        one_count = s.count("1")
        score = float('-inf')

        for i in range(len(s) - 1):
            if(s[i] == '0'):
                zero_count += 1
            else:
                one_count += 1
            
            score = max(score,  zero_count - one_count)
        if s[len(s) - 1] == '1':
            one_count += 1
        
        return score + one_count