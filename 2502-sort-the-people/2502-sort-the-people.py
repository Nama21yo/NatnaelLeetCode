class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        n = len(heights)

        maxi = max(heights)
        count_arr = [0] * (maxi + 1)
        for h in heights:
            count_arr[h] += 1

        sorted_heights = []
        for h in range(maxi, -1, -1):
            while count_arr[h] > 0:
                sorted_heights.append(h)
                count_arr[h] -= 1
        # /after the counting sort map them with height
        height_name = dict(zip(heights, names)) # height : name
        # print(height_name) {180: 'Mary', 165: 'John', 170: 'Emma'}
        return [height_name[height] for height in sorted_heights]
        