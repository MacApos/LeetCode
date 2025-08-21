package Arrays.LeetCode.v1;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = removeDuplicateLetters("ecbacba");
        System.out.println(s);
    }

    public static String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        HashSet<Character> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character peek = stack.peekLast();
            if (visited.contains(c)) {
                continue;
            }

            while (!stack.isEmpty() && peek > c && i < lastOccurrence.getOrDefault(peek, -1)) {
                visited.remove(stack.removeLast());
                peek = stack.peekLast();
            }

            visited.add(c);
            stack.addLast(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}
