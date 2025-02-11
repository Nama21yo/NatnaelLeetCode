class Solution:
    def canReorderDoubled(self, arr: List[int]) -> bool:
        double_arr = Counter(arr)

        for num in sorted(double_arr, key=abs): # sort by make it inside absolute value
            if  double_arr[num] > double_arr[2 * num]:
                return False
            double_arr[2 * num] -= double_arr[num]
        
        return True