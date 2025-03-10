package Intervals;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{4, 5}, {1, 5}};
        int[][] intervals3 = { {1, 4},{0, 2}, {3, 5}, {10, 15}};
        int[][] intervals4 = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] intervals5 = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        int[][] merge = merge(intervals3);
        System.out.println(Arrays.deepToString(merge));
    }

    public static int[][] myMerge(int[][] intervals) {
        int length = intervals.length;
        if (length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] arr = new int[length][];
        arr[0] = intervals[0];
        int idx = 0;

        for (int i = 1; i < length; i++) {
            int[] currInterval = intervals[i];
            int[] arrInterval = arr[idx];

            if (currInterval[0] <= arrInterval[1]) {
                arrInterval[1] = Math.max(currInterval[1], arrInterval[1]);
            } else {
                idx++;
                arr[idx] = currInterval;
            }
        }

        return Arrays.copyOfRange(arr, 0, idx+1);
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            if (curInterval[0] <= interval[1]) {
                interval[1] = Math.max(interval[1], curInterval[1]);
            } else {
                result.add(interval);
                interval = curInterval;
            }
        }
        result.add(interval);
        return result.toArray(new int[result.size()][2]);
    }


}
