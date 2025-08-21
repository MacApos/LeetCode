package Hashmap;

import java.util.HashSet;

public class HappyNumber {

    public static void main(String[] args) {
        boolean happy = isHappyV3(44);
        System.out.println(19 / 10);
        System.out.println(19 % 10);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            String[] split = String.valueOf(n).split("");
            n = 0;
            for (String s : split) {
                n += (int) Math.pow(Integer.parseInt(s), 2);
            }
            if (set.contains(n)) {
                return false;
            }

            if (Math.log10(n) % 1 == 0) {
                return true;
            }
            set.add(n);
        }
    }

    public static boolean isHappyV2(int n) {
        int check = 0;
        while (true) {
            int digit = n % 10;
            check = check + (int) Math.pow(digit, 2);
            n = n / 10;
            if (n == 0) {
                if (check > 0 && check < 10 && check != 7) {
                    break;
                }
                n = check;
                check = 0;
            }
        }
        return check == 1;
    }

    public static boolean isHappyV3(int n) {
        if (n == 1 || n == 7 || Math.log10(n) % 1.0 == 0 ) {
            return true;
        } else if (n < 9) {
            return false;
        } else {
            int sum = 0;
            while (n > 0) {
                sum += (int) Math.pow( n % 10, 2);
                n = n / 10;
            }
            return isHappyV3(sum);
        }
    }

}
