class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        n = len(heights)
        # Insertion Sort
        # first part is sorted
        for i in range(1,n):
            key_height = heights[i]
            key_name = names[i]

            j = i - 1
            # descending
            while j >= 0 and key_height > heights[j]:
                heights[j + 1] = heights[j]
                names[j + 1] = names[j]
                j -= 1
            heights[j + 1] = key_height
            names[j + 1] = key_name
        return names