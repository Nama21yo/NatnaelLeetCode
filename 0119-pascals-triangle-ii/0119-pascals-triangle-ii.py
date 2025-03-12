
        
class Solution:
    
    def getRow(self, rowIndex: int) -> List[int]:
        ans = [1]
        def helper(n):
            res = 1
            for i in range(n):
                res *= (n - i)
                res //= i + 1
                ans.append(res)
        helper(rowIndex)
        return ans
        