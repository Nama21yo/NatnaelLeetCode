class Solution {
    public int fib(int n) {
        return fibbo(n);
    }
    private int fibbo(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibbo(n - 1) + fibbo(n - 2);
    }
}