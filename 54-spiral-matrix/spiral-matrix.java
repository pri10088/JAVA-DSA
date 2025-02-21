class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowstart =0, rowend = matrix.length-1;
        int colstart =0, colend = matrix[0].length-1;
         List<Integer> ans = new ArrayList<>();
         while(rowstart<=rowend && colstart<=colend){

             for(int i = colstart; i<=colend; i++){
            ans.add(matrix[rowstart][i]);
        }
        rowstart++;
        for(int i=rowstart; i<= rowend; i++){
            ans.add(matrix[i][colend]);
        }
        colend--;
        if(rowstart<=rowend){
            for(int i = colend; i>=colstart; i--){
            ans.add(matrix[rowend][i]);
        }
        rowend--;

        }
        if(colstart<=colend){

            for(int i=rowend; i>=rowstart; i--){
            ans.add(matrix[i][colstart]);
        }
        colstart++;


        }
        
         }
         return ans;
       
        
    }
}