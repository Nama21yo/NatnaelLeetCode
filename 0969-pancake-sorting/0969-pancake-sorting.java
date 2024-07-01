class Solution {
    private void flip(int[] arr, int index) {
        for(int i = 0;i<= index/2;++i) {
              int temp = arr[i];
              arr[i] = arr[index-i];
              arr[index-i] = temp;
        }
      
    }
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> flips = new ArrayList();
        for(int i = arr.length - 1;  i > 0; --i) {
            for(int j = 1; j <= i;++j) {
                if(arr[j] == i+1) {
                    flip(arr,j);
                    flips.add(j+1);
                    break;
                }
            }
            flip(arr,i);
            flips.add(i+1);
        }
        return flips;
    }
}