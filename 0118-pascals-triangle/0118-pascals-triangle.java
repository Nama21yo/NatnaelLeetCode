class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 1; i <= numRows; i++) {
            ans.add(generateRow(i));
        }
        return ans;
    }
    
    private List<Integer> generateRow(int row) {
        List<Integer> rows = new ArrayList<>();
        int first = 1;
        rows.add(first);
        for(int i = 1; i < row; i++) {
            first = first * (row - i);
            first = first / i;
            rows.add(first);
        }
        
        return rows;
    }
}