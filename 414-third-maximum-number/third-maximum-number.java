class Solution {
    public int thirdMax(int[] nums) {
        
        Integer large = null, sec = null, third = null;
        for(int num: nums){
            if(Objects.equals(num, large) || Objects.equals(num, sec) || Objects.equals(num, third)){
                continue;
            }
            if( large == null || num > large){
                third = sec;
                sec = large;
                large = num;
            }
            else if(sec == null || num > sec){
                third =  sec;
                sec = num;
            }
            else if(third == null || num > third){
                third =  num;
                
            }
        }

        return(third == null) ? large : third;
    }
}