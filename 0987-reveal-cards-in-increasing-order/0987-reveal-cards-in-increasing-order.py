from collections import deque  

class Solution:  
    def deckRevealedIncreasing(self, deck: list[int]) -> list[int]:    
        deck.sort()  
        n = len(deck)  
         
        q = deque(range(n))  
        ans = [0] * n  
        
        i = 0  
        while q:  
            k = q.popleft()  
            ans[k] = deck[i]  
            i += 1  

            if q:  
                q.append(q.popleft())  
                
        return ans