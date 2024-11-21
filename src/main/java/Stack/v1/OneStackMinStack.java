package Stack.v1;

import java.util.Stack;

/*
in this methode subtractions between element value and minimum value are pushed to stack, minimum value is the lowest
integer pushed to stack
 */
public class OneStackMinStack {
    long min;
    Stack<Long> stack;

    public OneStackMinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min) {
                min = val;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        Long pop = stack.pop();
//        if popped element was min than min is set to previous min
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        Long peek = stack.peek();
//        if min element is not on top than return sum of min and last element
        if (peek > 0) {
            return (int) (min + peek);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }

}
