package Stack.v1;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "([{}])";
        String s2 = "(){}[]";
        boolean myIsValid = myIsValid(s);
        boolean bruteForceIsValid = bruteForceIsValid(s);
        boolean stackIsValid = stackIsValid(s2);
        System.out.println(stackIsValid);
    }

    //    wrong
    public static boolean myIsValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        int i = 0;
        while (i < s.length()) {
            Character key = hashMap.get(s.charAt(i));
            int j = i + 1;
            while (hashMap.containsKey(s.charAt(j))) {
                j++;
            }
            if (key != s.charAt(j)) {
                return false;
            }
            i = j;
        }
        return true;
    }

    public static boolean bruteForceIsValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.isEmpty();
    }

    public static boolean stackIsValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (hashMap.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == hashMap.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
