package binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();

        int n = heights.length+1;
        int[] arr = new int[n];
        System.arraycopy(heights, 0, arr, 1, n - 1);
        arr[0] = 0;

        int ans = 0;
        deque.addLast(0);
        for(int r=0; r<n-1; r++){
            // 出栈元素结算
            while(arr[deque.getLast()] > arr[r+1]){
                int cur = deque.removeLast();
                int l = deque.getLast();
                ans = Math.max(ans, arr[cur]*(r-l));
            }
            deque.addLast(r+1);
        }

        int pre = deque.removeFirst();
        while (!deque.isEmpty()){
            int l = pre;
            int cur = deque.getFirst();
            int r = deque.getLast();
            // System.out.println(cur + " " +  l + " " + r  + " " + arr[cur]);
            ans = Math.max(arr[cur] * (r-l), ans);
            pre = deque.removeFirst();
        }
        return ans;
    }
}
