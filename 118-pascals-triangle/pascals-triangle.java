class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(); 
        int n = numRows;
        if(numRows == 0){
            return triangle;
        }
        for(int row =0; row <n; row++){
           List<Integer> temp = new ArrayList<>();

            for(int col=0; col<=row; col++){
                if( col ==0 || col == row){
                    temp.add(1);
                }else{
                    int value = triangle.get(row-1).get(col - 1) + triangle.get(row - 1).get(col);
                    temp.add(value);
                }
            }
            triangle.add(temp);
            
        }
        return triangle;
        
    }
}