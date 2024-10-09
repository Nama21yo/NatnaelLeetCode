class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        # The Greedy One
        # '(' opening++
        #  ')' opening-- and closing_imbalance++

        # O(n) and O(1)
        opening = 0
        closing_imbalance = 0

        for c in s:
            if c == '(':
                opening += 1
            else:
                if opening == 0:
                    closing_imbalance += 1
                else:
                    opening -= 1
        
        return opening + closing_imbalance
        