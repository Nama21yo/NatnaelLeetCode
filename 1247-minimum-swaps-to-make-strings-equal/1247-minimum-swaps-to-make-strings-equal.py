class Solution:
    def minimumSwap(self, s1: str, s2: str) -> int:
        if len(s1) != len(s2):
            return -1
        
        xy = 0  # count of positions where s1[i]='x' and s2[i]='y'
        yx = 0  # count of positions where s1[i]='y' and s2[i]='x'
        
        for a, b in zip(s1, s2):
            if a == b:
                continue
            if a == 'x' and b == 'y':
                xy += 1
            else:
                yx += 1
        
        if (xy + yx) % 2:
            return -1
        
        swaps = (xy // 2) + (yx // 2)
        
        # if one leftover xy and one leftover yx -> needs 2 swaps
        if xy % 2 == 1:
            swaps += 2
        
        return swaps
