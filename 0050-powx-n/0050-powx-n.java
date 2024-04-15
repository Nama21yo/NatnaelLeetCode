class Solution {
    public double myPow(double x, int n) {
        double power = 1.0;
        long nn = n;
        // boolean isPositive = (n>0) ? true:false; 
        if(nn<0){
            nn = -1 * (nn);
        }


        while(nn > 0) {
            if(nn % 2 == 1) {
              power *= x;
              --nn;  
            }
            else {
                x = x*x;
                nn = nn/2;
            }
                
        }
        if(n<0) power = (double)(1.0)/power;
        return power;
        
    }
}