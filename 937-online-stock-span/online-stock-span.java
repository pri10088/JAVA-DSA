class StockSpanner {
        Stack<Pair> st;
        int index;

    public StockSpanner() {
        st = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index = index +1;
        while(!st.empty() && st.peek().price <= price){
            st.pop();
        }
        int ans = index - (st.empty() ? -1 : st.peek().ind);
        st.push(new Pair(price, index));
        return ans;
    }
}
class Pair{
    int price, ind;
    Pair(int price, int ind){
        this.price = price;
        this.ind = ind;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */