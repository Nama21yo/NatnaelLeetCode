class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int count = 1;
        int n = word.length();
        char comparator = word.charAt(0);

        for(int i = 1; i < n; i++) {
            if(word.charAt(i) == comparator && count < 9) {
                count++;
            } else {
                comp.append(count).append(comparator);
                comparator = word.charAt(i);
                count = 1;
            }
        }

        comp.append(count).append(comparator);
        return comp.toString();
        
    }
}