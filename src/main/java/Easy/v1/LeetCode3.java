package Easy.v1;

import java.util.*;

public class LeetCode3 {
    public static int myRomanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10,
                'L', 50, 'C', 100, 'D', 500, 'M', 1000);

        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer curr = map.get(chars[i]);
            Integer next = 0;

            if (i < chars.length - 1) {
                next = map.get(chars[i + 1]);
            }

            if (curr < next) {
                next = map.get(chars[i + 1]);
                res += (next - curr);
                i += 1;
            } else {
                res += curr;
            }
        }
        return res;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10,
                'L', 50, 'C', 100, 'D', 500, 'M', 1000);

        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer curr = map.get(chars[i]);

            if (i < chars.length - 1 && curr < map.get(chars[i + 1])) {
                res -= curr;
            } else {
                res += curr;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
