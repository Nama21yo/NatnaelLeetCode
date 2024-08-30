class Solution {
    public int majorityElement(int[] nums) {
        //Using HashMap
        Map<Integer,Integer> countMap = new HashMap<>();
        //storing the elements with its occurnce:
        for (int i = 0; i < nums.length; i++) {
            int value = countMap.getOrDefault(nums[i], 0);
            countMap.put(nums[i], value + 1);
        }

        //searching for the majority element:
        for (Map.Entry<Integer, Integer> it : countMap.entrySet()) {
            if (it.getValue() > (nums.length / 2)) {
                return it.getKey();
            }
        }
        
        

        return -1;
    }
}