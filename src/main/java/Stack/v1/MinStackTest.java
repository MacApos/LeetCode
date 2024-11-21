package Stack.v1;

public class MinStackTest {
    public static void main(String[] args) {
        TwoStackMinStack twoStackMinStack = new TwoStackMinStack();
        twoStackMinStack.push(-2);
        twoStackMinStack.push(0);
        twoStackMinStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());

        TwoStackMinStack twoStackMinStack2 = new TwoStackMinStack();
        twoStackMinStack2.push(512);
        twoStackMinStack2.push(-1024);
        twoStackMinStack2.push(-1024);
        twoStackMinStack2.push(512);
        twoStackMinStack2.pop();
//        System.out.println(twoStackMinStack2.getMin());
//        twoStackMinStack2.pop();
//        System.out.println(twoStackMinStack2.getMin());
//        twoStackMinStack2.pop();
//        System.out.println(twoStackMinStack2.getMin());

        OneStackMinStack oneStackMinStack = new OneStackMinStack();
        oneStackMinStack.push(2147483646);
        oneStackMinStack.push(2147483646);
        oneStackMinStack.push(2147483647);
        System.out.println(oneStackMinStack.top());
        oneStackMinStack.pop();
        System.out.println(oneStackMinStack.getMin());
        oneStackMinStack.pop();
        System.out.println(oneStackMinStack.getMin());
        oneStackMinStack.pop();
        oneStackMinStack.push(2147483647);
        System.out.println(oneStackMinStack.top());
        System.out.println(oneStackMinStack.getMin());
        oneStackMinStack.push(-2147483648);
        System.out.println(oneStackMinStack.top());
        System.out.println(oneStackMinStack.getMin());
        oneStackMinStack.pop();
        System.out.println(oneStackMinStack.getMin());
    }
}
