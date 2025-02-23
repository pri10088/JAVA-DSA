class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for( int n : nums){
            set.add(n);
        }
        int max =0;
        for(int num : set){
            if(! set.contains(num-1)){
                int currentNum = num;
                int sequence = 1;

                while(set.contains(currentNum+1)){
                    currentNum++;
                    sequence++;
                }
                max = Math.max(max, sequence);
            }
            
        }
        return max;
    }
}