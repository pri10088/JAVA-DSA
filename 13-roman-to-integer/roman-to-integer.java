class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        mpp.put('I', 1);
        mpp.put('V', 5);
        mpp.put('X', 10);
        mpp.put('L', 50);
        mpp.put('C', 100);
        mpp.put('D', 500);
        mpp.put('M', 1000);

        int total =0;
        int prev =0;
        for(int i=s.length()-1; i>=0; i--){
            int curr = mpp.get(s.charAt(i));

            if(curr < prev){
                total-=curr;
            }else{
                total+=curr;
            } 

            prev = curr;       
        }
        return total;
    }
}