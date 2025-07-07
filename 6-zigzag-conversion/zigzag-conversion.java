class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] row = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            row[i] = new StringBuilder();
        }
        int currow = 0;
        boolean flag = false;
        for(char ch: s.toCharArray()){
            row[currow].append(ch);

            if(currow == 0 || currow == numRows-1){
                flag = !flag;
            }
            currow += flag ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder r : row){
            result.append(r);
        }
        return result.toString();
    
    }
}