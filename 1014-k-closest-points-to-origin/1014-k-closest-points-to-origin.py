class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        points = sorted(points,key = lambda pt: pt[0]**2 + pt[1]**2)
        return points[:k]