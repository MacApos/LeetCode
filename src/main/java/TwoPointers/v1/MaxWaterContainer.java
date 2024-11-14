package TwoPointers.v1;

public class MaxWaterContainer {
    public static void main(String[] args) {
        int[] heights = {1, 7, 2, 5, 4, 7, 3, 6};
        int maxArea = maxArea(heights);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] heights) {
        int maxArea = 0;

        int start = 0;
        int end = heights.length - 1;

        while (start < end) {
            int left = heights[start];
            int right = heights[end];
            int distance = end - start;
            int area = Math.min(left, right) * distance;
            maxArea = Math.max(maxArea, area);

            if (left <= right) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
