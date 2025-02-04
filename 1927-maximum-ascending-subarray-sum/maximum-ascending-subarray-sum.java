class Solution {
    public int maxAscendingSum(int[] nums) {
        int max_sum =0, cur_sum =0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i==0 || nums[i]>nums[i-1]){
                cur_sum+=nums[i];
            }else {
                max_sum = Math.max(max_sum, cur_sum);
                cur_sum = nums[i];
            }
        }
        max_sum = Math.max(max_sum, cur_sum);
        return max_sum;
    }
}