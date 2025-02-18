package Arrays.NeedCode.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
https://leetcode.com/problems/valid-anagram/description/

UTF-8 and ASCII character chart
https://design215.com/toolbox/ascii-utf8.php
 */

public class ValidAnagram {
    public static long measureMemory(long freeMemory, long totalMemory) {
        return totalMemory - freeMemory;
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory();
        boolean anagram = isAnagram("racecar", "carrace");
        long totalMemory = runtime.totalMemory();
        System.out.println("Used memory:" + measureMemory(freeMemory, totalMemory));
        System.out.println(anagram);

        boolean sorting = sorting("racecar", "carrace");
        boolean hashTable = hashTable("racecar", "carrace");
        boolean hashTableOptimal = hashTableOptimal("racecar", "carrace");
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        List<String> sList = new ArrayList<>(Arrays.asList(s.split("")));
        String[] split = t.split("");
        for (String tString : split) {
            if (!sList.remove(tString)) {
                return false;
            }
        }
        return sList.isEmpty();
    }

    public static boolean sorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        return Arrays.equals(sCharArray, tCharArray);
    }

    public static boolean hashTable(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sHashMap = new HashMap<>();
        HashMap<Character, Integer> tHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sHashMap.put(s.charAt(i), sHashMap.getOrDefault(s.charAt(i), 0)+1);
            tHashMap.put(t.charAt(i), tHashMap.getOrDefault(t.charAt(i), 0)+1);
        }

        return sHashMap.equals(tHashMap);
    }

    public static boolean hashTableOptimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

//         26 chars in alphabet
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
//            add 1 to number of chars in alphabet array (- 'a' to get proper indexing) from s string
            count[s.charAt(i) - 'a']++;
//            subtract 1 from number of chars in alphabet array from t string
            count[t.charAt(i) - 'a']--;
        }
//        if strings are anagrams than array of chars in alphabet should contain only 0
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
