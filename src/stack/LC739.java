package stack;

import java.util.Stack;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        // Deque<Integer> stack = new ArrayDeque<>(); 优化比Stack好
        for(int i=0; i<temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = 0;
        }

        return answer;
    }
}
