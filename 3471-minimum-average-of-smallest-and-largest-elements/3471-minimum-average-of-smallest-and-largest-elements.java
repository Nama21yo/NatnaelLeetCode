class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double min_average = Double.MAX_VALUE;
        int n = nums.length;

        int l = 0;
        int r = n - 1;

        while(l <= r) {
            double average = ((double)nums[l] + nums[r])/ 2;
            min_average = Math.min(min_average, average);
            l++;
            r--;
        }

        return min_average;
    }
}