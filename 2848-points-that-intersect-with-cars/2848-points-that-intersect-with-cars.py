class Solution:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        number_line = defaultdict(int)
        for start, end in nums:
            number_line[start] += 1
            number_line[end + 1] -= 1
        

        running_sum = 0
        count = 0
        prev_pos = None

        for pos in sorted(number_line):
            if prev_pos is not None and running_sum > 0:
                count += pos - prev_pos

            running_sum += number_line[pos]
            prev_pos = pos

        return count
            