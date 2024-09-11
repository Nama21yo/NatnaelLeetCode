import java.util.Arrays;

class Solution {
    private int[] fibArray;  // Declare the memoization array as an instance variable
    
    public int fib(int n) {
        // Initialize the memoization array to store computed Fibonacci values
        fibArray = new int[n + 1];
        Arrays.fill(fibArray, -1);
        
        // Call the recursive helper function
        return fibbo(n);
    }
    
    private int fibbo(int n) {
        // Base cases
        if (n <= 1) {
            fibArray[n] = n;
            return n;
        }
        
        // Memoization: If already computed, return the stored value
        if (fibArray[n] != -1) {
            return fibArray[n];
        }
        
        // Recursive case with memoization
        fibArray[n] = fibbo(n - 1) + fibbo(n - 2);
        return fibArray[n];
    }
}
