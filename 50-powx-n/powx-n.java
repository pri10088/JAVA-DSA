class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n; // use long to handle Integer.MIN_VALUE case

        if (nn < 0) {
            nn = -nn;
            x = 1 / x;
        }

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans *= x;
                nn -= 1;
            } else {
                x *= x;
                nn /= 2;
            }
        }

        return ans;
    }
}
