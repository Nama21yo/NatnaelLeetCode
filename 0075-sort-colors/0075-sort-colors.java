class Solution {
    public void sortColors(int[] nums) {
        //Dutch National Flag Algorithm
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        while(mid <= high) {
            switch(nums[mid]) {
                case(0):
                    int temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    
                    mid++;
                    low++;
                    break;
                case(1):
                    mid++;
                    break;
                case(2):
                    temp = nums[high];
                    nums[high] = nums[mid];
                    nums[mid] = temp;
                    high--;
                    //don't make the mid++
                    break;
                default:
                    break;
            }
        }
    }
}