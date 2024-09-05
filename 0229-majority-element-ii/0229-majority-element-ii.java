class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> countEl = new HashMap<>();
        
        List<Integer> ans = new ArrayList<>();
        int mini = (int)Math.floor(nums.length / 3) + 1;
        for(int i = 0; i < nums.length; i++) {
            countEl.put(nums[i], countEl.getOrDefault(nums[i],0) + 1);
            if(countEl.get(nums[i]) == mini) ans.add(nums[i]);
        }
        return ans;
    }
}