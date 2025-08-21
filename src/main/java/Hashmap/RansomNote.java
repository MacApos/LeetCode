package Hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        boolean canConstruct = canConstructV4("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj");
        System.out.println(canConstruct);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i)-'a']++;
            if(i< ransomNote.length()){
                chars[ransomNote.charAt(i)-'a']--;
            }
        }
        for (int c : chars) {
            if(c<0){
                return false;
            }
        }
        return true;
    }

    public static boolean canConstructV2(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            hashMap.merge(magazine.charAt(i), 1, (oldVal, newVal) ->oldVal+1);
            if(i < ransomNote.length()){
                hashMap.merge(magazine.charAt(i), -1, (oldVal, newVal) ->oldVal-1);
            }
        }
        return hashMap.values().stream().noneMatch(v->v<0);
    }

    public static boolean canConstructV3(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            hashMap.merge(magazine.charAt(i), 1, (oldVal, newVal) -> oldVal + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!hashMap.containsKey(c)) {
                return false;
            }
            hashMap.computeIfPresent(c, (k, v) -> v - 1);
            if (hashMap.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstructV4(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (char c : magazine.toCharArray()) {
            chars[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if(--chars[c-'a'] < 0){
                return false;
            }
        }
        return true;
    }

}
