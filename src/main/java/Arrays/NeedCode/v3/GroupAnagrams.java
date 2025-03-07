package Arrays.NeedCode.v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        String[] strs2 = {"ac","c"};
        List<List<String>> lists = groupAnagrams(strs2);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = "";
            for (char c : charArray) {
                key += c;
            }

            if(hashMap.containsKey(key)){
                hashMap.get(key).add(str);
            } else {
                hashMap.put(key, new ArrayList<>(List.of(str)));
            }
        }
        return hashMap.values().stream().toList();
    }
}
