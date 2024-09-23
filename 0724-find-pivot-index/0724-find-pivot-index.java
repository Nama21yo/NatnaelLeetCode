class Solution {
    public int pivotIndex(int[] arr) {
        
        int n = arr.length; // Get the length of the array  

        // Handle the case for an empty array  
        if (n == 0) return -1;  

        int net = 0;  

        // Calculate the total sum of the array  
        for (int i = 0; i < n; i++) {  
            net += arr[i];  // Corrected to use 'arr' instead of 'A'  
        }  
        
        int left = 0;  
        int right = net; // Initialize right with the total sum  

        // Iterate through the array to find the equilibrium index  
        for (int i = 0; i < n; i++) {  
            // Update right for current index  
            right -= arr[i];  
            
            // Check if left sum equals right sum  
            if (left == right) {  
                return i; // Returning the equilibrium index  
            }  
            
            // Update left for the next iteration  
            left += arr[i];  
        }  

        return -1; // Return -1 if no equilibrium index is found  

    }
}