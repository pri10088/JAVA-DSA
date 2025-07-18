class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = first(nums, target);
        ans[1] = last(nums, target);
        return ans;
    }
    public int first(int nums[], int target){
        int low =0, high = nums.length-1, first = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                first = mid;
                 high = mid - 1; 
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return first;
    }
        public int last(int nums[], int target){
        int low =0, high = nums.length-1, last = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                last = mid;
                low = mid+1;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return last;
    }
}