class Solution {
    public boolean check(int[] nums) {
        int cnt =1, n = nums.length;
        if(n == 1){
            return true;
        }
        for(int i =1; i< 2*n; i++){
            if(nums[(i-1)%n] <= nums[i%n]){
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