package heap;

import java.util.PriorityQueue;

public class LC295 {
    // 大根堆
    private PriorityQueue<Integer> left;
    // 小根堆
    private PriorityQueue<Integer> right;

    public LC295() {
         left = new PriorityQueue<>((a, b) -> b-a);
         right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 保证 left.size >= right.size()
        if(left.size() <= right.size()){
            // left + 1
            // 1. 如果 num 本来就该在右侧，那么需要先加入 right，再从 right 取最小值加到 left
            // 2. 如果 num 本来就该在左侧，那么 1 结果加到 left 的就是 num，所以可以合并
            right.add(num);
            left.add(right.poll());
        }else {
            // right + 1
            left.add(num);
            right.add(left.poll());
        }
    }

    public double findMedian() {
        if(left.isEmpty()){
            return 0;
        }
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }else{
            return left.peek();
        }
    }

}
