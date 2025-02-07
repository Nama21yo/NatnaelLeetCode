class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        maxi = 0

        for candy in candies:
            maxi = max(maxi, candy)
        
        ans = []
        for candy in candies:
            if candy + extraCandies >= maxi:
                ans.append(True)
            else:
                ans.append(False)
        
        return ans