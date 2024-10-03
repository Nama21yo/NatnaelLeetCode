class Solution {
    public void duplicateZeros(int[] arr) {
        int l = 0;
        int n =  arr.length;
        while(l < n - 1) {
            if(arr[l] == 0) {
                int r = n - 1;
                while(r >= l + 2) {
                    arr[r] = arr[r - 1];
                    r--;
                }
                arr[l + 1] = 0;
                l += 2; 
            } else {
                l++;
            }
        }
    }
}
