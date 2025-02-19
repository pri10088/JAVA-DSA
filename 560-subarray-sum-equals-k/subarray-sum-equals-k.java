class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, sum=0, cnt=0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        for(int i=0; i<n; i++){
            sum+=nums[i];

            int rem = sum - k;
            cnt+=mpp.getOrDefault(rem, 0);
            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);

        }
        return cnt;
        
    }
}