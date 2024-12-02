class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # Combination of m + n - 1 to n -1
        row = min(m,n)
        col = max(m,n)

        def fact(num):
            answer = 1
            for i in range(1 , num + 1):
                answer *= i
            return answer
        res = fact(row + col - 2)
        den = fact(row - 1)
        r = fact(col - 1)

        combination = int(res / ((den)*(r)))
        return combination
       

        