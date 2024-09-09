class Solution:
    def findErrorNums(self, arr: List[int]) -> List[int]:
        N = len(arr)

        xr = 0  # XOR of all elements and numbers from 1 to N

        # Perform XOR of all array elements and numbers from 1 to N
        for i in range(N):
            xr = xr ^ arr[i]
            xr = xr ^ (i + 1)

        # Find the rightmost set bit in xr (the bit where the two numbers differ)
        bitNo = 0
        while True:
            if (xr & (1 << bitNo)) != 0:
                break
            bitNo += 1

        # Classify the numbers based on the found bit
        zero = 0
        one = 0

        # XOR all elements in the array, based on the bitNo classification
        for i in range(N):
            if (arr[i] & (1 << bitNo)) != 0:
                one = one ^ arr[i]
            else:
                zero = zero ^ arr[i]

        # XOR numbers from 1 to N, again based on the bitNo classification
        for i in range(1, N+1):
            if (i & (1 << bitNo)) != 0:
                one = one ^ i
            else:
                zero = zero ^ i

        # Determine which is repeating and which is missing
        count = 0
        for i in range(N):
            if arr[i] == zero:
                count += 1

        # If 'zero' is the repeating number
        if count == 2:
            return [zero, one]

        # Otherwise, 'one' is the repeating number
        return [one, zero]
