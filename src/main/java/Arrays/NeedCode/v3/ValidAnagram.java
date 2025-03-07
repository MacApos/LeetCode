package Arrays.NeedCode.v3;

public class ValidAnagram {
    public static void main(String[] args) {
        boolean isAnagram = isAnagram("racecar", "racecar");
        System.out.println(isAnagram);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCodes = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCodes[s.charAt(i) - 'a']++;
            charCodes[t.charAt(i) - 'a']--;
        }

        for (int charCode : charCodes) {
            if (charCode != 0) {
                return false;
            }
        }

        return true;
    }
}
