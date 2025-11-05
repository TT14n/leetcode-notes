package binarysearch;
import java.util.TreeSet;

public class LC729 {
    class MyCalendar {
        // 使用二分查找来查找 calendar，因为 calendar 中的日程都是不冲突的，也就是不重叠的，因此很好查找判断
        private TreeSet<int[]> calendar = new TreeSet<>((a, b) -> a[0] - b[0]);
        // private int[][] calendar = new int[100000][2];
        public MyCalendar() {
        }

        public boolean book(int startTime, int endTime) {
            // 二分查找到第一个[s2, e2) 的 s2 >= endTime，判断前一个的 [s1, e1) 中的 e1 <= startTime 即可插入
            // ceiling >=, floor <=, higher >, lower <
            int[] date = new int[]{startTime, endTime};
            if(calendar.isEmpty()){
                calendar.add(date);
                return true;
            }

            // 第一个 >= startTime 的 date
            int[] ceilingDate = calendar.ceiling(date);
            if(ceilingDate != null && endTime > ceilingDate[0]) return false;
            
            // 第一个 < startTime 的 date
            int[] lowerDate = calendar.lower(date);
            if(lowerDate != null && lowerDate[1] > startTime) return false;
            
            calendar.add(date);
            return true;
        }

    }
    
    public static void main(String[] args) {
        LC729 solution = new LC729();
        MyCalendar obj = solution.new MyCalendar();
        // 调用列表中的预约
        System.out.println(obj.book(97, 100)); // true
        System.out.println(obj.book(33, 51));  // true
        System.out.println(obj.book(89, 100)); // false (与[97,100]冲突)
        System.out.println(obj.book(83, 100)); // false (与[97,100]冲突)
    }
}

