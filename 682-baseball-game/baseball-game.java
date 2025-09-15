class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String op : operations){
            if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                stack.push(stack.peek()*2);
            }else if(op.equals("+")){
                int last = stack.pop();
                int sec = stack.peek();
                stack.push(last);
                stack.push(sec+last);
            }else{
                stack.push(Integer.parseInt(op));
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}