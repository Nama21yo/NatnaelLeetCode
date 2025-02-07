class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        n,m  = len(img), len(img[0])
        # Using Bit Manipulation
        for r in range(n):
            for c in range(m):
                # r-1 -> r + 1
                # c - 1 -> c+1
                total_sum = 0
                count = 0
                for i in range(r - 1, r + 2):
                    for j in range(c - 1 , c + 2):
                        if i < 0 or i == n or j < 0 or j == m:
                            continue
                        total_sum += img[i][j] % 256
                        count += 1
                
                img[r][c] = img[r][c] ^ (total_sum // count) << 8
        
        for r in range(n):
            for c in range(m):
                img[r][c] = img[r][c] >> 8
        
        return img 

        