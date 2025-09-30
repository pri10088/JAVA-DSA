import java.math.BigInteger;

class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        BigInteger comb = BigInteger.ONE; // C(n-1,0)
        BigInteger res = BigInteger.ZERO;
        BigInteger TEN = BigInteger.TEN;

        for (int i = 0; i < n; i++) {
            res = res.add(comb.multiply(BigInteger.valueOf(nums[i]))).mod(TEN);
            if (i < n - 1) {
                comb = comb.multiply(BigInteger.valueOf(n - 1 - i))
                           .divide(BigInteger.valueOf(i + 1)); // exact division
            }
        }
        return res.intValue();
    }
}
