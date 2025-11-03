package dp;

public class LC729 {
    static class MyCalendar {
    private int[][] calendar = new int[100000][2];
    private int size = 0;
    public MyCalendar() {
    }

    public boolean book(int startTime, int endTime) {
        for (int i = 0; i < size; i++){
            if(startTime >= calendar[i][0] && startTime < calendar[i][1] ||
                    endTime > calendar[i][0] && endTime <= calendar[i][1] ||
                    startTime < calendar[i][0] && endTime >= calendar[i][1]){
                return false;
            }
        }
        calendar[size][0] = startTime;
        calendar[size][1] = endTime;
        size++;
        return true;
    }

    }
    
    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        // 调用列表中的预约
        System.out.println(obj.book(97, 100)); // true
        System.out.println(obj.book(33, 51));  // true
        System.out.println(obj.book(89, 100)); // false (与[97,100]冲突)
        System.out.println(obj.book(83, 100)); // false (与[97,100]冲突)
    }
}

