class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int req = n * (n+1)/2;
        int cur = 0;
        for(int i=0; i<n; i++){
            cur+=nums[i];

        }
        return req-cur;
        
    }
}