package Arrays.LeetCode.v1.Arrays;
/*
    https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
*/

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] words2 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do", "do"};
        String[] words3 = {"This", "is", "an", "example", "of", "text", "justification."};

        int maxWidth = 16;
        int maxWidth2 = 20;
        List<String> strings = fullJustify(words2, maxWidth2);
        strings.forEach(str -> System.out.println(str.replaceAll(" ", "-")));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int length = words.length;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            ArrayList<String> lineList = new ArrayList<>();
            int wordsLength = 0;
            StringBuilder lineText = new StringBuilder(words[i]);

//            separate words to lines
            while (true) {
                String word = words[i];
                lineList.add(word);
                wordsLength += word.length();
                if (i == length - 1) {
                    break;
                }
                lineText.append(" ").append(words[i + 1]);
                if (lineText.length() > maxWidth) {
                    break;
                }
                i++;
            }

//            distribute spaces between words
            int size = lineList.size();
            StringBuilder join = new StringBuilder(lineList.get(0));
            if (size > 1) {
                int space = 1;
                int extraSpace = 0;
                if (i != length - 1) {
                    space = (maxWidth - wordsLength) / (size - 1);
                    extraSpace = (maxWidth - wordsLength) % (size - 1);
                }

                for (int j = 1; j < size; j++) {
                    join.append(" ".repeat(space));
                    if (extraSpace > 0) {
                        join.append(" ");
                    }
                    join.append(lineList.get(j));
                    extraSpace--;
                }
            }

            join.append(" ".repeat(maxWidth - join.length()));
            result.add(join.toString());
        }
        return result;
    }
}
