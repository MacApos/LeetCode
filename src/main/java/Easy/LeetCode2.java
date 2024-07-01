package Easy;

public class LeetCode2 {
    public static boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        String strInt = String.valueOf(x);
        char[] chars = strInt.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length / 2; i++) {
            if (strInt.charAt(i) != strInt.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean solutionWithInt(int num) {
        int digits = (int) Math.log10(num) + 1;
        System.out.println(digits);
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
        System.out.println(121%10);
    }
}
