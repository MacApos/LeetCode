package Stack.v2;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"1", "2", "+", "3", "*", "4", "-"};
        String[] tokens2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] tokens3 = {"2", "1", "+", "3", "*"};
        String[] tokens4 = {"4", "13", "5", "/", "+"};
        int stackEvalRPN = stackEvalRPN(tokens2);
        System.out.println(stackEvalRPN);

    }

    public static int stackEvalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int lastInt;
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    lastInt = stack.pop();
                    stack.push(stack.pop() - lastInt);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    lastInt = stack.pop();
                    stack.push(stack.pop() / lastInt);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
