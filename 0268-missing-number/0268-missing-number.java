class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            xor2 = xor2 ^ nums[i]; // XOR of all elements in the array
            xor1 = xor1 ^ (i + 1);  // XOR of all numbers from 1 to n
        }
        return xor1 ^ xor2; // XOR of the above two will give the missing number
    }
}
