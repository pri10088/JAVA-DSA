class Solution {
    public int longestConsecutive(int[] nums) {
        Set <Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int curNum =0;
        int index =0, max=0;
        for(int num : set){
            if(! set.contains(num - 1)){
                curNum = num;
                index = 1;

                while(set.contains(curNum + 1)){
                    curNum++;
                    index++;
                }
            }
            max = Math.max(max, index);
        }
        return max;
        
    }
}