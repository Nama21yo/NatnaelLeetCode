class Solution:
    def maximumSubarraySum(self, A: list[int], k: int) -> int:
        mp = defaultdict(int)
        mx = 0
        window_sum = 0
        
        for i in range(len(A)):
            window_sum += A[i]
            mp[A[i]] += 1
            
            if i >= k - 1:
                if len(mp) == k:
                    mx = max(mx, window_sum)
                
                # Remove the element that is sliding out of the window
                outgoing = A[i - k + 1]
                window_sum -= outgoing
                mp[outgoing] -= 1
                
                # Remove the outgoing element if its count drops to 0
                if mp[outgoing] == 0:
                    del mp[outgoing]
        
        return mx
