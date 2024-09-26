class Solution:
    def maxScore(self, s: str) -> int:
        zero_count = 0
        one_count = s.count("1")
        answer = 0

        for i in range(len(s) - 1):
            if(s[i] == '0'):
                zero_count += 1
            else:
                one_count -= 1
            
            answer = max(answer,  zero_count + one_count)
        
        return answer