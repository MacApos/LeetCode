package Stack.v1;

import java.util.Objects;
import java.util.Stack;

class TwoStackMinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public TwoStackMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if(Objects.equals(pop, minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

