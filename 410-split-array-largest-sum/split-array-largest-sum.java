class Solution {
    public int check(int[] arr, int mid){
        int count =  1;
        int sum = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i] + sum <= mid){
                sum += arr[i];
            } else{
                count++;
                sum = arr[i];
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        if(nums.length < k) return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int i=0; i<nums.length; i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }  
        if(nums.length == k) return low;
        while(low <= high){
            int mid = low + (high - low)/2;
            int count = check(nums, mid);
            if(count > k) low = mid + 1;
            else high = mid -1 ;
        }    
        return low;  
    }
}