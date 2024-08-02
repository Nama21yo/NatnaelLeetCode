class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n;i++) { 
            int currGcd = nums[i];
            
            for(int j = i;j < n;j++){
                currGcd = gcd(currGcd,nums[j]);
                if(currGcd == k) ans++;
            }
        }
        
        return ans;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}