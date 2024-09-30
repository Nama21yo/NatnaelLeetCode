class Solution {
    public boolean isUgly(int n) {
        if(n == 0) return false;
        while( n % 2 == 0) n = n / 2;
        while(n % 3 == 0) n = n / 3;
        while(n % 5 == 0) n = n / 5;
        if(n > 0 && n <= 3) return true;
        return false;
     }

}