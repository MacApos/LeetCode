package Arrays.LeetCode.v1;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        int i = strStrV2("mississippi", "issip");
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }

        return -1;
    }

    public static int strStrV2(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        int j = 0;
        for (int i = 0; i < h - n + 1; i++) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                continue;
            }
            while (haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
                if (j == n) {
                    return i;
                }
            }
            j = 0;

        }
        return -1;
    }
}
