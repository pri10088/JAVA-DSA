class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if(nn<0){
            nn = -nn;
            x = 1/x;
        }
        while(nn > 0){
            if(nn%2==0){
                x = x*x;
                nn = nn/2;
            }else{
                ans = ans*x;
                nn = nn-1;
            }
        }
       return ans;
    }
}