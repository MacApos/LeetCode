package Stack.v2;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([])";
        String s4= "()";
//        ([])
        boolean isValid = isValid(s4);
        System.out.println(isValid);
    }

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for(char c: s.toCharArray()){
            String strChar = Character.toString(c);
            if("{[(".contains(strChar)){
                stack.push(strChar);
            } else  {
                if (stack.isEmpty()) {
                    return false;
                }

                String pop = stack.pop();
                if( pop.equals("{") && !strChar.equals("}") ||
                    pop.equals("[") && !strChar.equals("]") ||
                    pop.equals("(") && !strChar.equals(")")){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
