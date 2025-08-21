package Arrays.LeetCode.v1;

public class ZigZagConversion {
    public static void main(String[] args) {
        String s = zigZagPattern("PAY", 4);
    }

    public static String zigZagPattern(String s, int numRows) {
        int length = s.length();
        if (numRows < 2) {
            return s;
        }
        int offset = 2 * numRows - 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < length) {
                result.append(s.charAt(j));
                int zigZag = j + offset - (i * 2);
                if (i > 0 && i < numRows - 1 && zigZag < length) {
                    result.append(s.charAt(zigZag));
                }
                j += offset;
            }
        }
        return result.toString();
    }
}

/*
        P   A   H   N
        A P L S I I G
        Y   I   R

        0P     6I    12N
        1A   5L 7S  11I 14G
        2Y 4A   8H 10R
        3P     9I
 */