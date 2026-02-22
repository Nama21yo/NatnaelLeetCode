class Solution:
    def binaryGap(self, n: int) -> int:
        last = -1
        max_gap = 0
        
        for i in range(32):  
            if (n >> i) & 1:  # check if i-th bit is 1
                if last != -1:
                    max_gap = max(max_gap, i - last)
                last = i
        
        return max_gap