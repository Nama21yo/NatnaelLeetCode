class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Step 1: Copy the original array and sort it
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        // Step 2: Create a map to assign ranks
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Step 3: Assign ranks to each element in the sorted array
        for (int num : sortedArr) {
            // Only assign a rank to the number if it hasn't been assigned yet (no duplicates)
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // Step 4: Build the result array by replacing each element with its rank
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}
