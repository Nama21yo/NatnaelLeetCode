class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        # O(n + klogn)
        score = 0
        max_heap = [-n for n in nums]
        heapq.heapify(max_heap)

        while k:
            maxi = abs(heapq.heappop(max_heap))
            score += maxi
            heapq.heappush(max_heap, -math.ceil(maxi / 3))
            k -= 1

        return score
        