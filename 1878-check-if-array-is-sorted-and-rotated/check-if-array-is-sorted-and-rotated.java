class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int cnt =0;
        for(int i=1; i< 2* n; i++){
            if(nums[(i-1) % n] <= nums[i%n]){
                cnt++;
            }else{
                cnt =1;
            }
            if(cnt == n){
                return true;
            }
        }
        return false;
    }
}