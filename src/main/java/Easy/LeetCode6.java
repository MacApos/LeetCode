package Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode6 {
    public static int getLen(ListNode list) {
        if (list == null) {
            return 0;
        }

        int count = 1;
        while (list.next != null) {
            list = list.next;
            count++;
        }
        return count;
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        while (list1 != null) {
            if (list2.val <= list1.val) {

            } else {
                ListNode temp = list1.next;
                list1.next = list2;
                list2.next = temp;
            }
            list1 = list1.next;
        }
        return new ListNode();
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        mergeTwoLists(list1, list2);

        List<Integer> l1 = List.of(10, 20, 40);
        List<Integer> l2 = List.of(2, 4, 300);

        List<Integer> longerList = l1;
        List<Integer> shorterList = l2;
        if (l1.size() < l2.size()) {
            shorterList = l1;
            longerList = l2;
        }

        ArrayList<Integer> res = new ArrayList<>(longerList);
        for (int i = 0; i < shorterList.size(); i++) {
            boolean flag = true;
            Integer e1 = shorterList.get(i);
            for (int j = 0; j < longerList.size(); j++) {
                Integer e2 = longerList.get(j);
                if (e1 <= e2) {
                    res.add(res.indexOf(e2), e1);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(e1);
            }
        }
        System.out.println(res);
    }
}
