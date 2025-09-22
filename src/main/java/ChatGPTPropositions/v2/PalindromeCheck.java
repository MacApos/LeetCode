package ChatGPTPropositions.v2;

public class PalindromeCheck {
    public static void main(String[] args) {
        boolean iterate = iterate("A man, a plan, a canal: Panama");
        boolean twoPointers = twoPointers("A man, a plan, a canal: Panama");
        System.out.println(twoPointers);
    }

    public static boolean iterate(String str) {
        str = str.toLowerCase().replaceAll("[ ,.:;]", "");
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean twoPointers(String str) {
        int start = 0;
        int end = str.length() - 1;
        str = str.toLowerCase();
        while (start < end) {
            char startChar = str.charAt(start);
            char endChar = str.charAt(end);

            if (!Character.isLetterOrDigit(startChar)) {
                start++;
                continue;
            }

            if (!Character.isLetterOrDigit(endChar)) {
                end--;
                continue;
            }

            if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
