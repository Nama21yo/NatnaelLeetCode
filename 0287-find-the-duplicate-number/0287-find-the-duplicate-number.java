class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> countNum = new HashMap<>();

        // Populate the map with the frequency of each number
        for (int i = 0; i < nums.length; i++) {
            countNum.put(nums[i], countNum.getOrDefault(nums[i], 0) + 1);
        }

        // Iterate through the map and return the number which has a count greater than 1
        for (int key : countNum.keySet()) {
            if (countNum.get(key) > 1) {
                return key;
            }
        }

        // In case there's no duplicate (though problem assumes there is always one)
        return -1;
    }
}
