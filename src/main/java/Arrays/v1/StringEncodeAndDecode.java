package Arrays.v1;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {
    public static void main(String[] args) {
        List<String> input = List.of("need", "code", "love", "you");
        String encode = encode(input);
        List<String> output = decode(encode);
        System.out.println(input);
        System.out.println(output);
    }

    public static String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str.length()).append("#").append(str);
        }
        return stringBuilder.toString();
    }

    public static List<String> decode(String str) {
        System.out.println(str);
        List<String> result = new ArrayList<>(List.of());
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            result.add(str.substring(i, j));
            i = j;
        }

        return result;
    }
}
