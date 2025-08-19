class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return helper(nums,k)-helper(nums,k-1);
    }
    public static int helper(int nums[],int k){
        if(k<0) return 0;
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        int start=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start])==0)
                    map.remove(nums[start]);
                start++;
            }
            count+=(i-start+1);
        }
        return count;
    }
}