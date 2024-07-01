package Easy;

public class LeetCode4 {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            System.out.println(prefix);
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static String myLongestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }

        String firstWord = strs[0];
        int shortestWord = firstWord.length();
        for (int i = 1; i < strs.length; i++) {
            if (shortestWord > strs[i].length()) {
                shortestWord = strs[i].length();
            }
        }
        String res = "";
        for (int i = 1; i <= shortestWord; i++) {
            String substring = firstWord.substring(0, i);
            for (int j = 1; j < length; j++) {
                if (!strs[j].substring(0, i).equals(substring)) {
                    return res;
                }
            }
            res = substring;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(myLongestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(myLongestCommonPrefix(new String[]{"flower", "flower", "flower"}));
//        System.out.println(myLongestCommonPrefix(new String[]{"dog", "racecar", "car"}));
//        System.out.println(myLongestCommonPrefix(new String[]{"ab", "a"}));
//        System.out.println(myLongestCommonPrefix(new String[]{"a"}));

        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("flower".indexOf("flower"));


    }
}
