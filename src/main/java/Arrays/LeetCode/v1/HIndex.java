package Arrays.LeetCode.v1;

import java.util.*;

public class HIndex {
    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        int[] citations2 = {1, 3, 1};
        int[] citations3 = {1};
        int[] citations4 = {11, 15};
        int[] citations5 = {10, 8, 0, 6, 3, 1};
        int slowMyHIndex = slowMyHIndex(citations1);
        int myHIndex = myHIndex(citations2);
        int myHIndexReverse = hIndex(citations5);
    }

    public static int slowMyHIndex(int[] citations) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int hIndex = 0;
        for (int citation : citations) {
            citation = Math.min(citation, citations.length);
            for (int i = 1; i <= citation; i++) {
                hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
                if (hashMap.get(i) == i) {
                    hIndex = i;
                }
            }
        }
        System.out.println(hashMap);
        return hIndex;
    }

    public static int myHIndex(int[] citations) {
        int hIndex = 0;
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            int citation = citations[i];
            if (citation <= length - i) {
                hIndex = citation;
            }
        }

        return hIndex;
    }

    public static int hIndex(int[] citations) {
        int length = citations.length;
        int[] frequency = new int[length+1];

        for (int citation : citations) {
            frequency[Math.min(citation, length)]++;
        }

        int citationInPaper = 0;
        for (int i = length; i >= 0; i--) {
            citationInPaper += frequency[i];
            if(i <= citationInPaper){
                return i;
            }
        }

        return 0;
    }

}
