package Stack.v1;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s1 = "1 + 1";
        String s2 = " 2-1 + 2 ";
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        String s4 = "-(2 + 3)-(2+4)";
        int myCalculate = myCalculate(s4);
        System.out.println(myCalculate);
    }

    public static int myCalculate(String s) {
        return compute(s.replaceAll("\\s", "")
                .replaceAll("\\+", ""), 0)[1];
    }

    public static int[] compute(String s, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean isNegative = false;
        char[] charArray = s.toCharArray();
        int i = start;
        while (i < charArray.length) {
            char c = charArray[i];
            if (c == '-') {
                isNegative = true;
            } else if (c == ')') {
                break;
            } else {
                int digit = c - '0';
                if (c == '(') {
                    int[] arr = compute(s, i + 1);
                    digit = arr[1];
                    i = arr[0];
                }

                if (isNegative) {
                    digit *= -1;
                    isNegative = false;
                }
                stack.push(stack.isEmpty() ? digit : stack.pop() + digit);
            }
            i++;
        }
        return new int[]{i, stack.peek()};
    }
}
