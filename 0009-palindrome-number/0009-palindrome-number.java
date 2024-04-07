class Solution {
    public static boolean isPalindrome(int x) {
        int y = 0;
        int temp = x;
        while(x > 0){
            y = (x%10) + (y*10);
            x=x/10;
        }
        return (temp==y) ? true:false;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome(121));
    }
}