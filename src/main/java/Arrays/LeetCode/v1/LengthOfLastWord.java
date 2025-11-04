package Arrays.LeetCode.v1;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        int length = 0;
        for (int i = trim.toCharArray().length - 1; i >= 0; i--) {
            if(trim.charAt(i)==' '){
                return length;
            }
            length ++;
        }
        return length;
    }

    public static int lengthOfLastWordV2(String s) {
        int length = 0;
        int lastLength = 0;
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                length++;
                lastLength = length;
            } else {
                length = 0;
            }
        }

        return lastLength;
    }
}
