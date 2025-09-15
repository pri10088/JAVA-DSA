class MyQueue {
    Stack<Integer> s1 = new Stack<>(); // input stack
    Stack<Integer> s2 = new Stack<>(); // output stack

    // push to back of queue
    public void push(int x) {
        s1.push(x);
    }

    // pop from front of queue
    public int pop() {
        moveIfNeeded();
        return s2.pop();
    }

    // peek front element
    public int peek() {
        moveIfNeeded();
        return s2.peek();
    }

    // check empty
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // helper: transfer only when s2 is empty
    private void moveIfNeeded() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}
