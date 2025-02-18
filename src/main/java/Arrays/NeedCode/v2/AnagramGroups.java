package Arrays.NeedCode.v2;

import java.util.*;

public class AnagramGroups {
    public static void main(String[] args) {
       String[] strs = {"act","pots","tops","cat","stop","hat"};
        List<List<String>> groupAnagrams = groupAnagrams(strs);
        List<List<String>> optimalGroupAnagrams = optimalGroupAnagrams(strs);
        System.out.println(optimalGroupAnagrams);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();

            int[] count = new int[26];
            for (int i = 0; i < charArray.length; i++) {
                count[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);

            stringListHashMap.putIfAbsent(key, new ArrayList<>());
            stringListHashMap.get(key).add(str);

        }

        return new ArrayList<>(stringListHashMap.values());
    }

    public static List<List<String>> optimalGroupAnagrams(String[] strs){
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);

            stringListHashMap.putIfAbsent(key, new ArrayList<>());
            stringListHashMap.get(key).add(str);

        }
        return new ArrayList<>(stringListHashMap.values());
    }

}


