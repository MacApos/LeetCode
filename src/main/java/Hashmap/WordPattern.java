package Hashmap;

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        boolean isWordPattern = wordPattern("abba", "cat dog dog cat");
        System.out.println(isWordPattern);
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        HashMap<Character, String> hashMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String splitS = split[i];
            String hashMapS = hashMap.get(c);
            if (hashMapS != null) {
                if (!hashMapS.equals(splitS)) {
                    return false;
                }
            } else if (hashMap.containsValue(splitS)) {
                    return false;
            } else {
                hashMap.put(c, splitS);
            }
        }
        return true;
    }
}
