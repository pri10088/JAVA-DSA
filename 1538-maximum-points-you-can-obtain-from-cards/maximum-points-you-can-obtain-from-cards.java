class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int lsum=0, rsum =0, sum=0;
        for(int i=0; i<k; i++){
            lsum+=cardPoints[i];
        }
        int max=lsum;
        int rindex = n-1;
        for(int i = k-1; i>=0; i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rindex];
            sum = lsum+rsum;
            rindex--;

            max = Math.max(max, sum);
        }

        
        return max;
    }
}