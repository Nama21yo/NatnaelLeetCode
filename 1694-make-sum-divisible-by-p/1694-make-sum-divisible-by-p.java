class Solution {
    public int minSubarray(int[] nums, int p) {
        // currentSum  -  x = rem
        // x = currentSum - rem
        // x = (currentSum - rem + p) % p
        int sum = 0;
        for(int num : nums) {
            sum = (sum + num) % p;
        }

        int mod = sum % p; // 4
        if(mod == 0) return 0;

        int ans = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int currentSum = 0;
        for(int i = 0; i < nums.length; ++i) {
            currentSum = (currentSum + nums[i]) % p;
            int neededSum = (currentSum - mod + p) % p;
            if(map.containsKey(neededSum)) {
                ans = Math.min(ans, i - map.get(neededSum));
            }
            map.put(currentSum, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}