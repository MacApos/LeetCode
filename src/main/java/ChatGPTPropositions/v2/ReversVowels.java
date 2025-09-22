package ChatGPTPropositions.v2;

import java.util.*;

public class ReversVowels {
    public static void main(String[] args) {
        System.out.println(twoPointers("Aello"));
    }

    public static final HashSet<Character> vowels = new HashSet<>(Set.of(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String str) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (vowels.contains(charAt)) {
                arrayList.add(i);
                arrayList.add(j, (int) charAt);
                j++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder(str);
        int size = arrayList.size();
        for (int i = 0; i < size / 2; i++) {
            stringBuilder.setCharAt(
                    arrayList.get(size - i - 1),
                    (char) (int) arrayList.get(i));
        }

        return stringBuilder.toString();
    }

    public static String twoPointers(String str) {
        int start = 0;
        int end = str.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(str);
        while (start < end ) {
            char startChar = str.charAt(start);
            char endChar = str.charAt(end);
            if (!vowels.contains(startChar)) {
                start++;
                continue;
            }

            if (!vowels.contains(endChar)) {
                end--;
                continue;
            }

            stringBuilder.setCharAt(start, endChar);
            stringBuilder.setCharAt(end, startChar);

            start++;
            end--;
        }

        return stringBuilder.toString();
    }

    public static void replaceChars(StringBuilder stringBuilder, int start, char startChar,
                                    int end, char endChar){
        stringBuilder.setCharAt(start, endChar);
        stringBuilder.setCharAt(end, startChar);
    }

}
