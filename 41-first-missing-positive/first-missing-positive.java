class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int l = nums.length;
        for(int n : nums){
            set.add(n);
        }
        for(int i=1; i<=l; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return l+1;
    }
}