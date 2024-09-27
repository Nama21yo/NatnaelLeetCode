class Solution {
    public int largestAltitude(int[] gain) {
        int prefixLeftSum = 0;
        int largestAltitude = 0;
        for(int i = 0; i < gain.length; i++) {
            prefixLeftSum += gain[i];
            largestAltitude = Math.max(largestAltitude, prefixLeftSum);
        }

        return largestAltitude;
    }
}