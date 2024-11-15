package Arrays.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramGroups {
    public static void main(String[] args) {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
        groupAnagrams(strs);
        System.out.println(optimalGroupAnagrams(strs));
        System.out.println(superOptimalGroupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> setListHashMap = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> charIntHashMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                charIntHashMap.put(charAt, charIntHashMap.getOrDefault(charAt, 0) + 1);
            }
            if (setListHashMap.containsKey(charIntHashMap)) {
                setListHashMap.get(charIntHashMap).add(str);
            } else {
                setListHashMap.put(charIntHashMap, new ArrayList<>(List.of(str)));
            }
        }
        return setListHashMap.values().stream().toList();
    }

    public static List<List<String>> optimalGroupAnagrams(String[] strs) {
        HashMap<String, List<String>> arrayListHashMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            arrayListHashMap.putIfAbsent(key, new ArrayList<>());
            arrayListHashMap.get(key).add(str);
        }
        return new ArrayList<>(arrayListHashMap.values());
    }

    public static List<List<String>> superOptimalGroupAnagrams(String[] strs) {
        HashMap<String, List<String>> arrayListHashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            if (!arrayListHashMap.containsKey(key)) {
                arrayListHashMap.put(key, new ArrayList<>());
            }
            arrayListHashMap.get(key).add(str);
        }
        return new ArrayList<>(arrayListHashMap.values());
    }

}
