package CodingBat.string;

public class StringSameEnds {
    public static void main(String[] args) {
        String string = sameEnds("abXabCabYab");
        System.out.println(string);
    }

    public static String sameEnds(String string) {
        String start = "";
        String end = "";
        String result = "";

        for (int i = 0; i < string.length() / 2; i++) {
            start += string.charAt(i);
            end = string.charAt(string.length() - i - 1) + end;
            if (start.equals(end)) {
                result = start;
            }
        }
        return result;
    }


}
