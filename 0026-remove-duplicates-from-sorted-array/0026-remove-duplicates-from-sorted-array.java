class Solution {
    static int removeDuplicates(int[] arr) {
    
    int len = 0;
    for(int i = 1; i< arr.length;i++) {
      // for(int j=0;j<setss.length;j++) {
        if(arr[i] != arr[len]) {//1 
          len++;        
          arr[len] = arr[i];
        }
      // }
    }
    return len+1;
    } 

  public static void main(String[] args) {
    int[] ar = {3,3,3,5,6,7}; 
    int len = removeDuplicates(ar);
    for(int i = 0; i < len;i++) {
      System.out.print(ar[i] + " ");  //5 8 4 4 3 6 
    }
    System.out.println();
}
}