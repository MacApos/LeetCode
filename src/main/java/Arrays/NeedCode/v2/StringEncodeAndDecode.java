package Arrays.NeedCode.v2;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {
    public static void main(String[] args) {
        List<String> strs = List.of("neet", "code", "love", "you");
        String encode = encode(strs);
        List<String> decode = decode(encode);
        System.out.println(decode);
    }

    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("-").append(str);
        }
        return res.toString();
    }

    public static List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int n = i;
            while (str.charAt(n) != '-') {
                n++;
            }
            int length = Integer.parseInt(str.substring(i, n));
            n++;
            i = n + length;
            result.add(str.substring(n, i));
        }
        return result;
    }
}
