package Arrays.LeetCode.v1;

import java.util.ArrayDeque;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        trap(height);
    }

    public static int trap(int[] height) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int result = 0;
        for (int i = 1; i < height.length; i++) {
            int currH = height[i];

            while (!deque.isEmpty() && currH > height[deque.peek()]) {
                int pop = height[deque.pop()];
                if (!deque.isEmpty()) {
                    int prevH = height[deque.peek()];
                    int h = Math.min(prevH, currH) - pop;
                    int w = i - deque.peek() - 1;
                    result += h * w;
                }
            }
            deque.push(i);


        }
        return result;
    }
}
