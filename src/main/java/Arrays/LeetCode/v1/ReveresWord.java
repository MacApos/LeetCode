package Arrays.LeetCode.v1;

public class ReveresWord {
    public static void main(String[] args) {
        String s = reverseWords("  hello world  ");
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        int length = split.length;
        StringBuilder result = new StringBuilder(split[length - 1]);
        for (int i = length - 2; i >= 0; i--) {
            result.append(" ").append(split[i]);
        }
        return result.toString();
    }
}
