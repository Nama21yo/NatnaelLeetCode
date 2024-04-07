class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] answer = new int[2* nums.length];
        int end = answer.length-1;
        int start = 0;
        while(start<end){
            answer[start]=nums[start];
            answer[end]=nums[(nums.length-1)-start]; 
            start++;
            end--;
        }
        return answer;
        
    }
}