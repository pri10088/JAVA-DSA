class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        int ans=n;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] >= target){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}