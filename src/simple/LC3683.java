package simple;

public class LC3683 {
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<tasks.length; i++){
            min = Math.min(min, tasks[i][0] + tasks[i][1]);
        }
        return min;
    }

    public static void main(String[] args) {
        LC3683 sol = new LC3683();
        int result = sol.earliestTime(new int[][]{{1, 6}, {2, 3}});
        System.out.println(result);
    }
}

