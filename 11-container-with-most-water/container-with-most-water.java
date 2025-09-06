class Solution {
    public int maxArea(int[] height) {
        int left =0, right = height.length-1;
        int maxArea =0, area =0;
        while(left <right){
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
            
        }
        return maxArea;
    }
}