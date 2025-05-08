class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int ls = 0;
        int rs = 0;
        for(int i=0; i<n; i++){
            rs+=nums[i];
        }
        for(int i=0; i<n; i++){
            rs-=nums[i];
            if(ls == rs){
                return i;
            }
            ls+=nums[i];
        }
        return -1;
        
    }
}