package Easy;

public class SecondLargestDigitInAString {
    public static void main(String[] args) {
        int i = secondHighest("sjhtz8344");
        System.out.println(i);
    }

    public static int secondHighest(String s) {
        char[] chars = s.toCharArray();
        int max = -1;
        int secondMax = -1;
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                continue;
            }
            int digit = c - '0';
            if (digit > max) {
                secondMax = max;
                max = digit;
            }
            else if (digit > secondMax) {
                secondMax = digit;
            }
        }

        return secondMax;
    }
}
