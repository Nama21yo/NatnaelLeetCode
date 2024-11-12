class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        items.sort() #[price,beauty]
        queries = sorted([(q,i) for i,q in enumerate(queries)])

        answer = [0] * len(queries)
        max_beauty = 0
        j = 0
        for q, i in queries:
            while j < len(items) and items[j][0] <= q:
                max_beauty = max(max_beauty, items[j][1])
                j += 1
            
            answer[i] = max_beauty
        

        return answer