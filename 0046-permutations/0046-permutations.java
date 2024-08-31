class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        
        backtrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }
    
    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList,int[] nums) {
        //base case
        if(tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int number: nums) {
            //skip if we get same element
            if(tempList.contains(number)) continue;
            
            tempList.add(number);
            
            backtrack(resultList,tempList,nums);
            
            tempList.remove(tempList.size() - 1);
        }
    }
}