class Solution {
    public int minGroups(int[][] intervals) {
        int minStart = Integer.MAX_VALUE;
        int maxStart = Integer.MIN_VALUE;

        for(int inter[] : intervals) {
            minStart = Math.min(minStart, inter[0]);
            maxStart = Math.max(maxStart, inter[1]);
        }

        int arr[] = new int[maxStart + 2];

        for(int inter[] : intervals) {
            arr[inter[0]]++;
            arr[inter[1] + 1]--;
        }

        int ans = 0;
        int currentSum = 0;

        for(int i = 0; i < arr.length; ++i) {
            currentSum += arr[i];
            ans = Math.max(ans, currentSum);
        }

        return ans;



    }
}