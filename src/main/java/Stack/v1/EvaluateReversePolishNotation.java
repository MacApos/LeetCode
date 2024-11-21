package Stack.v1;

/*
[10,6,9,3,+,-11,*,/,*,17,+,5,+]
(((9+3)*-11)/6)*10+17+5
 */

import java.util.*;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"1", "2", "+", "3", "*", "4", "-"};
        String[] tokens2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] tokens3 = {"2", "1", "+", "3", "*"};
        String[] tokens4 = {"4", "13", "5", "/", "+"};
        int myEvalRPN = myEvalRPN(tokens4);
        int myBruteForceEvalRPN = myBruteForceEvalRPN(tokens2);
        int bruteForceEvalRPN = bruteForceEvalRPN(tokens2);
        int optimalEvalRPN = optimalEvalRPN(tokens4);
        int recursionEvalRPN = recursionEvalRPN(tokens4);
        System.out.println(myBruteForceEvalRPN);
    }

    public static int performOperations(String operation, int a, int b) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }

//    same but little different
    public static int myBruteForceEvalRPN(String[] tokens) {
        ArrayList<String> tokensList = new ArrayList<>(Arrays.asList(tokens));

        int i = 0;
        while (tokensList.size() > 1) {
            String token = tokensList.get(i);
            while (!"+-*/".contains(token) && i < tokensList.size() - 1) {
                i++;
                token = tokensList.get(i);
            }

            int last = Integer.parseInt(tokensList.get(i - 1));
            int oneBeforeLast = Integer.parseInt(tokensList.get(i - 2));
            int result;

            if (token.equals("+")) {
                result = oneBeforeLast + last;
            } else if (token.equals("-")) {
                result = oneBeforeLast - last;
            } else if (token.equals("*")) {
                result = oneBeforeLast * last;
            } else {
                result = oneBeforeLast / last;
            }

            tokensList.set(i - 2, String.valueOf(result));
            tokensList.remove(i);
            tokensList.remove(i - 1);
            i -= 1;

        }

        return Integer.parseInt(tokensList.get(0));
    }

    public static int bruteForceEvalRPN(String[] tokens) {
        ArrayList<String> tokensList = new ArrayList<>(Arrays.asList(tokens));

        while (tokensList.size() > 1) {
            for (int i = 0; i < tokensList.size(); i++) {
                String token = tokensList.get(i);
                if("+-*/".contains(token)){
                    int last = Integer.parseInt(tokensList.get(i - 1));
                    int oneBeforeLast = Integer.parseInt(tokensList.get(i - 2));
                    int result;

                    if (token.equals("+")) {
                        result = oneBeforeLast + last;
                    } else if (token.equals("-")) {
                        result = oneBeforeLast - last;
                    } else if (token.equals("*")) {
                        result = oneBeforeLast * last;
                    } else {
                        result = oneBeforeLast / last;
                    }


                    tokensList.set(i - 2, String.valueOf(result));
                    tokensList.remove(i);
                    tokensList.remove(i - 1);
                    break;
                }
            }
        }

        return Integer.parseInt(tokensList.get(0));
    }

    public static int myEvalRPN(String[] tokens) {
        HashMap<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("-", (a, b) -> a - b);
        operations.put("+", (a, b) -> a + b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);

        Stack<Integer> integers = new Stack<>();
        for (String token : tokens) {
            if (operations.containsKey(token)) {
                BiFunction<Integer, Integer, Integer> function = operations.get(token);
                Integer last = integers.pop();
                Integer oneBeforeLast = integers.pop();
                integers.push(function.apply(oneBeforeLast, last));
            } else {
                integers.push(Integer.parseInt(token));
            }
        }

        return integers.peek();
    }

    public static int optimalEvalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                Integer tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                Integer tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    public static int recursionEvalRPN(String[] tokens) {
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        return dfs(tokenList);
    }

    private static int dfs(List<String> tokens) {
        String token = tokens.remove(tokens.size() - 1);

        if (!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }

        int right = dfs(tokens);
        int left = dfs(tokens);

        switch (token) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
        }

        return 0;
    }

}
