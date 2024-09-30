class Solution:
    def captureForts(self, forts: List[int]) -> int:
        max_forts = 0
        n = len(forts)
        # There should be -1 at the end
        for i in range(n):
            if forts[i] == 1:
                # Check to the left
                left = i - 1
                left_forts = 0
                while left >= 0 and forts[left] == 0:
                    left_forts += 1
                    left -= 1
                # Ensure an enemy fort (-1) is present at the end of the sequence
                if left >= 0 and forts[left] == -1:
                    max_forts = max(max_forts, left_forts)
                
                # Check to the right
                right = i + 1
                right_forts = 0
                while right < n and forts[right] == 0:
                    right_forts += 1
                    right += 1
                # Ensure an enemy fort (-1) is present at the end of the sequence
                if right < n and forts[right] == -1:
                    max_forts = max(max_forts, right_forts)
        
        return max_forts
