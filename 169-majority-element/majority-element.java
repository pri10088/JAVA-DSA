class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length; 
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<n; i++){
            int value = mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], value+1);
            

        }
        for(int key : mpp.keySet()){
            if(mpp.get(key)> n/2){
                return key;
            }
        }
        return -1;
    }
}