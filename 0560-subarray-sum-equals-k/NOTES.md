Explanation:
Initialization:
​
arr_sums.put(0, 1) initializes the arr_sums map to handle the case where a subarray that starts from index 0 sums to k.
sum keeps track of the cumulative sum of elements as we iterate through the array.
result counts the number of subarrays that sum to k.
Main Logic:
​
sum += nums[i] updates the cumulative sum with the current element.
if (arr_sums.containsKey(sum - k)) checks if there is a previously seen sum such that the difference between the current sum and this previous sum equals k. This means we have found a subarray that sums to k.
arr_sums.put(sum, arr_sums.getOrDefault(sum, 0) + 1) updates the map with the current cumulative sum.
Efficiency:
​
Time Complexity: O(n), where n is the number of elements in the array, because each element is processed once.
Space Complexity: O(n), for storing the cumulative sums in the HashMap.