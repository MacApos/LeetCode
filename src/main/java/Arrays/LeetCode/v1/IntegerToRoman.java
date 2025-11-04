package Arrays.LeetCode.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {
        String s = intToRoman(3999);
        System.out.println(s);
    }

    public static String intToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            int value = values[i];
            while (num >= value) {
                result.append(symbols[i]);
                num -= value;
            }
        }
        return result.toString();
    }

    public static String intToRomanV2(int num) {
        HashMap<Integer, String> hashMap = new HashMap<>(Map.of(
                1, "I",
                5, "V",
                10, "X",
                50, "L",
                100, "C",
                500, "D",
                1000, "M"
        ));

        ArrayList<Integer> nums = new ArrayList<>();
        while (num > 0) {
            nums.add(num % 10);
            num = num / 10;
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nums.size(); i++) {
            Integer currNum = nums.get(i);
            int decimal = (int) Math.pow(10, i);
            if (currNum < 4) {
                result.insert(0, hashMap.get(decimal).repeat(currNum));
            } else if (currNum == 4 || currNum == 9) {
                result.insert(0, hashMap.get(decimal) + hashMap.get((currNum + 1) * decimal));
            } else {
                result.insert(0, hashMap.get(decimal * 5) + hashMap.get(decimal).repeat(currNum - 5));
            }
        }

        return result.toString();
    }
}
