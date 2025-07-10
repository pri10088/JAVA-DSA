class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, result);
        return result;
    }
    public void backtrack(List<Integer> current, int[] nums, List<List<Integer>> result){
         if(current.size() == nums.length){
        result.add(new ArrayList<>(current));
        return;
    }
    for(int i=0; i<nums.length; i++){
        if(current.contains(nums[i])) continue;
        current.add(nums[i]);
        backtrack(current, nums, result);
        current.remove(current.size()-1);
    }
    }
}