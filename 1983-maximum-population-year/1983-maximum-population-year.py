class Solution:
    def maximumPopulation(self, logs: List[List[int]]) -> int:
        line = defaultdict(int)
        for p in logs:
            line[p[0]] += 1
            line[p[1]] -= 1
        max_p = 0
        ans_year = 0
        count = 0
        for year in sorted(line):
            count += line[year]
            if count > max_p:
                max_p = count
                ans_year = year
        return ans_year