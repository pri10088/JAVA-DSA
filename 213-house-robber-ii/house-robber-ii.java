class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int case1 = robLinear(nums, 0, n-2);
        int case2 = robLinear(nums, 1, n-1);   
        return Math.max(case1, case2);       
    }
    public int robLinear(int[] nums,int start, int end){
        int prev1 =0;
        int prev2 =0;
        for(int i=start; i<=end; i++){
            int cur = Math.max(prev1, prev2+nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}