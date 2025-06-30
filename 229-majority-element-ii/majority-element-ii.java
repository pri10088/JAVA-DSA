class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = 0, el2 = 0;
        
        for(int i=0; i<n; i++){
            if(cnt1 == 0 && nums[i] != el2){
                cnt1 =1;
                el1 = nums[i];
            }else if(cnt2 ==0 && nums[i] != el1){
                cnt2 = 1;
                el2 = nums[i];
            }else if(el1 == nums[i]){
                cnt1++;
            }else if(el2 == nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        int count1 =0, count2 =0;
        for(int i=0; i<n; i++){
            if(el1 == nums[i]) count1++;
            else if(el2 == nums[i]) count2++;
        }
        List<Integer> list = new ArrayList<>();
        if(count1 > n/3) list.add(el1);
        if(count2 > n/3) list.add(el2);
        return list;
        

    }
}