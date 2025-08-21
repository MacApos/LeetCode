package Hashmap;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        boolean isomorphic = isIsomorphic("badc", "baba");
        System.out.println(isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            Character c = hashMap.get(sc);
            if (c != null) {
                if (!c.equals(tc)) {
                    return false;
                }
            } else if (hashMap.containsValue(tc)) {
                return false;
            }
            hashMap.put(sc, tc);
        }
        return true;
    }
}
