package Easy.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode5 {
//    public static boolean myIsValid(String s) {
//        int length = s.length();
//        if (map.containsKey(s.substring(length - 1, length))) {
//            return false;
//        }
//
//        StringBuilder closing = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            String current = s.substring(i, i + 1);
//            if (map.containsKey(current)) {
//                closing.insert(0, map.get(current));
//            } else {
//                int closingLen = closing.length();
//                if (!s.substring(i, i + closingLen).contentEquals(closing)) {
//                    return false;
//                }
//                i += closingLen - 1;
//                closing = new StringBuilder();
//            }
//        }
//        return true;
//    }

    static HashMap<Character, Character> map = new HashMap<>(Map.of(')', '(',
            '}', '{', ']', '['));

    public static boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        int length = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < length; i++) {
            char aChar = chars[i];
            if (map.containsValue(aChar)) {
                stack.add(aChar);
            } else {
                int last = stack.size() - 1;
                if (stack.isEmpty() || !stack.get(last).equals(map.get(aChar))) {
                    return false;
                }
                stack.remove(last);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}([])"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("]"));
        System.out.println(isValid("()"));

    }
}
