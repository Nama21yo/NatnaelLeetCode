class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key = lambda x:x[1])
        last_finishing = float("-inf")
        min_operation = 0
        # Interval Scheduling
        for start, end in points:
            if start > last_finishing:
                min_operation += 1
                last_finishing = end
        return min_operation