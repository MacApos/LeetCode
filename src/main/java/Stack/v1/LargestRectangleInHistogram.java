package Stack.v1;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights2 = {2, 4};
        int[] heights3 = {2, 1, 2};
        int[] heights4 = {3,6,5,7,4,8,1,0};
        int largestRectangleArea = largestRectangleArea(heights4);
        System.out.println(largestRectangleArea);
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, heights[0]});
        int maxRectangle = 0;

        for (int i = 1; i < heights.length; i++) {
            int currHeight = heights[i];
            int currIndex = i;
            while (!stack.isEmpty() && stack.peek()[1] > currHeight) {
                int[] pop = stack.pop();
                int areaForward = pop[1] * (i - pop[0]);
                maxRectangle = Math.max(maxRectangle, areaForward);
                currIndex=pop[0];
            }
            if (currIndex < i) {
                int areaBackward = currHeight * (i - currIndex + 1);
                maxRectangle = Math.max(maxRectangle, areaBackward);
            }
            stack.push(new int[]{currIndex, currHeight});
        }

        if (!stack.isEmpty()) {
            for (int[] arr : stack) {
                int areaForward = arr[1] * (heights.length - arr[0]);
                maxRectangle = Math.max(maxRectangle, areaForward);
            }
        }

        return maxRectangle;
    }
}
