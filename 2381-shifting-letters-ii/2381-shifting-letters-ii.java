class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftAmount = new int[n + 1];
        
        // Populate the shiftAmount array using the difference array concept
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            // If direction is 1 (right shift), add 1 to start and subtract 1 from end + 1
            if (direction == 1) {
                shiftAmount[start] += 1;
                shiftAmount[end + 1] -= 1;
            } 
            // If direction is 0 (left shift), subtract 1 from start and add 1 to end + 1
            else {
                shiftAmount[start] -= 1;
                shiftAmount[end + 1] += 1;
            }
        }
        
        // Apply the cumulative shifts
        int currentShift = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            currentShift += shiftAmount[i];
            // Normalize shift to be within the range of 0 to 25
            int shift = ((result[i] - 'a') + currentShift) % 26;
            if (shift < 0) shift += 26; // Handle negative shifts
            result[i] = (char)('a' + shift);
        }
        
        return new String(result);
    }
}
