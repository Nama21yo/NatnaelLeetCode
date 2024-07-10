class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // Initialize the result list to store all combinations
        List<List<Integer>> list = new ArrayList<>();
        
        // Start backtracking from the first element
        backtrack(list, n, k, new ArrayList<>(), 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int n, int k, List<Integer> temp, int start) {
        // Base case: If k is zero, add the current combination to the result list
        if (k == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        // Iterate from start to the maximum possible value for the combination
        for (int i = start; i <= n - k + 1; i++) {
            // Add the current number to the temporary list
            temp.add(i);

            // Recursively backtrack with the remaining numbers and one less element to pick
            backtrack(list, n, k - 1, temp, i + 1);

            // Remove the last added number to backtrack and try the next number
            temp.remove(temp.size() - 1);
        }
    }
}
