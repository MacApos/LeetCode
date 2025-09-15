package ChatGPTPropositions;

import java.util.HashMap;

public class FindFirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String findFirst = findFirst("swiss");
        System.out.println(findFirst);

    }

    public static String findFirst(String str) {
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

    public static String findFirstV2(String str) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        Integer[] integers = new Integer[str.length()];



        for (int i = 0; i < str.length(); i++) {
            hashMap.put(str.charAt(i), i);
        }

        return null;

    }
}