package ChatGPTPropositions.v2;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedList {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 3, 5));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(2, 4, 6, 8));
        List<Integer> sorted = mergeSorted(list1, list2);
        System.out.println(sorted);
    }

    public static List<Integer> mergeSorted(List<Integer> list1, List<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            Integer element1 = list1.get(i);
            Integer element2 = list2.get(j);
            if (element1 < element2) {
                result.add(element1);
                i++;
            } else {
                result.add(element2);
                j++;
            }
        }

        while(i < list1.size()){
            result.add(list1.get(i));
            i++;
        }

        while(j < list2.size()){
            result.add(list2.get(j));
            j++;
        }


        return result;
    }
}
