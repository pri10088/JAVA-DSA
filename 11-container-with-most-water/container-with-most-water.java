class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = height.length - 1, max=0;
        while(left<right){
            int width = right - left;
            int heights = Math.min(height[left], height[right]);
            int area = width*heights;
            max = Math.max(max, area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return max;
    }
}