package greedy;

import java.util.Arrays;


public class LC2589 {
    public int findMinimumTime(int[][] tasks) {
        // N^2
        // 贪心：为什么越后面执行越好？ ==> 越可能遇到可以一起执行的任务，不会担心遗漏

        // 按照 end 升序
        Arrays.sort(tasks, (a,b) -> a[1]-b[1]);
        int[] timePoint = new int[2010];
        
        int result = 0;
        for(int[] task: tasks){
            int start = task[0], end = task[1], duration = task[2];
            
            // 删除已经累积的时间点
            for (int i = start; i <= end; i++) {
                duration -= timePoint[i];
            }

            // 更新统计
            for(int i=end; i>=start && duration>0; i--){
                if(timePoint[i] == 0){
                    duration--;
                    timePoint[i] = 1;
                    result++;
                }
            }
            
            // for(int i=0; i<=end; i++){
            //     System.out.print(timePoint[i] + " ");
            // }
            // System.out.println(result +"\n");

            
        }

        return result;
    }
    public static void main(String[] args) {
        LC2589 solution = new LC2589();
        System.out.println(solution.findMinimumTime(new int[][]{{1,3,2},{2,5,3},{5,6,2}}));
    }
}
