class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<n; i++){
            int value = mpp.getOrDefault(nums[i],0);
            mpp.put(nums[i],value+1);
        }
        for(Map.Entry<Integer, Integer> it : mpp.entrySet()){
            if(it.getValue() > n/3){
                list.add(it.getKey());
            }
        }
        return list;

    }
}