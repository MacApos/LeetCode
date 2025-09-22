package ChatGPTPropositions.v2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class FindFirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String firstHashMap = findFirstHashMap("swiss");
        String firstQueue = findFirstQueue("swiss");
        String firstQueueV2 = findFirstQueueV2("swiss");
        System.out.println(firstQueueV2);

    }


    public static String findFirstHashMap(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            hashMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        for (char c : str.toCharArray()) {
            if (hashMap.get(c) == 1) {
                return Character.toString(c);
            }
        }
        return null;
    }

    public static String findFirstQueue(String str) {

        Deque<Character> characters = new ArrayDeque<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            hashMap.merge(c, 1, (k, v) -> v + 1);
            if (hashMap.get(c) == 1) {
                characters.offer(c);
            }
            while (!characters.isEmpty() && hashMap.get(c) > 1) {
                characters.poll();
            }
        }

        return characters.isEmpty() ? null : Character.toString(characters.peek());

    }

    private static String findFirstQueueV2(String str) {
        int[] chars = new int[26];
        Deque<Character> characters = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            int idx = c - 'a';
            chars[idx]++;
            int aChar = chars[idx];
            if (aChar == 1) {
                characters.offer(c);
            }
            while (!characters.isEmpty() && chars[characters.peek()-'a'] > 1) {
                characters.poll();
            }
        }

        return characters.isEmpty() ? null : Character.toString(characters.peek());
    }
}