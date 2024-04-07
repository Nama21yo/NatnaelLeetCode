class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] answer = new int[2* nums.length];
        int index=0;
        for(int i = 0,j=nums.length;i<answer.length;i++){
            if(i<nums.length)
                answer[i]=nums[i];
            else{
                answer[j]= nums[index];
                j++;
                index++;   
            }  
        }
        return answer;
        
    }
}