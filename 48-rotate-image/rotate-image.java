class Solution {
    public void rotate(int[][] matrix) {
        //step 1 transpose 
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<=n-2; i++){
            for(int j=i; j<=n-1; j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //reverse each row
        for(int i=0; i<n; i++){
            for(int j=0; j< n/2; j++){
                int temp = matrix[i][j];
                 matrix[i][j]=matrix[i][n-1-j] ;
                 matrix[i][n-1-j] = temp;

            }
        }

        
    }
}