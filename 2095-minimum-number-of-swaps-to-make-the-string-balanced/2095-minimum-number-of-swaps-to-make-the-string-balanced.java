class Solution {
    public int minSwaps(String s) {
        // count min swap = (Imbalance count + 1) / 2
        int imbalance_count = 0;
        int current_count = 0;
        // [ = -1 , ] = 1
        for(char c : s.toCharArray()) {
            if(c == '[') {
                current_count -= 1;
            } else {
                current_count += 1;
            }
            imbalance_count = Math.max(imbalance_count, current_count);
        }

        return (imbalance_count + 1) / 2;
    }
}