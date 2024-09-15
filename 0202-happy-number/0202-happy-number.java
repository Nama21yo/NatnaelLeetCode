class Solution {
    private int findSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n % 10) * (n % 10);
            n = n /  10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = findSum(n);
        while(fast != 1 && slow != fast) {
            slow = findSum(slow);
            fast = findSum(findSum(fast));
        }
        return fast == 1;
    }
}
