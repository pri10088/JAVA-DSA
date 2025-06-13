class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, sum=0;
        int required = (n*(n+1))/2;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        int ans = required - sum;
        return ans;
        
    }
}