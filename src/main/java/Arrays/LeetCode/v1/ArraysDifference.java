package Arrays.LeetCode.v1;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysDifference {
    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + 1) + min;
    }

    public static void main(String[] args) {
        int[] a = new int[getRandomNumber(1, 10)];
        int[] b = new int[getRandomNumber(1, 10)];

        for (int i = 0; i < Math.max(a.length, b.length); i++) {
            if (i < a.length) {
                a[i] = getRandomNumber(0, 10);
            }
            if (i < b.length) {
                b[i] = getRandomNumber(0, 10);
            }
        }

        System.out.println("a=" + Arrays.toString(a));
        System.out.println("b=" + Arrays.toString(b));

        HashSet<Integer> set = new HashSet<>();
        for (int j : b) {
            set.add(j);
        }

        int[] c = new int[a.length];
        int j = 0;
        for (int k : a) {
            if (!set.contains(k)) {
                c[j] = k;
                j++;
            }
        }
        int[] result = Arrays.copyOfRange(c, 0, j);
        System.out.println("method1=" + Arrays.toString(result));

        ArrayList<Integer> collect = Arrays.stream(a)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        collect.removeAll(Arrays.stream(b)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new)));

        System.out.println("method2=" + collect);

        int aI = 0;
        int bI = 0;
        int lastEqual = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (aI < a.length && bI < b.length) {
            int aElem = a[aI];
            int bElem = b[bI];

            if (aElem < bElem) {
                arrayList.add(aElem);
                aI++;
            } else if (aElem > bElem) {
                bI++;
            } else {
                lastEqual = aElem;
                aI++;
                bI++;
            }
        }

        while (aI < a.length){
            if(a[aI] != lastEqual){
                arrayList.add(a[aI]);
            }
            aI++;
        }
        System.out.println("method3="+arrayList);
    }


}

