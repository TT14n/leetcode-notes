package dp;
public class LC2896_sol1 {
    public static void main(String[] args) {
        LC2896_sol1 solution = new LC2896_sol1();
        System.out.println(solution.minOperations("1100011000", "0101001010", 2));
    }
    public int minOperations(String s1, String s2, int x) {
        // 记忆化搜索结果，压缩搜索状态
        int n = s1.length();
        // 如果需要翻转的数目，不是偶数，则不可能达成目标
        int diff = 0;
        for(int i=0; i<n; i++){
            diff ^= s1.charAt(i) == s2.charAt(i) ? 0 : 1;
        }

        if(diff != 0) return -1;

        // 第1维记录节点（0~n-1），第2维记录还剩多少次免费额度(0~n)，第3维表示当前位是否被“延迟翻转”(0,1)
        int[][][] record = new int[n][n+1][2]; 
        for(int i=0; i<record.length; i++){
            for(int j=0; j<record[0].length; j++){
                record[i][j][0] = record[i][j][1] = -1;
            }
        }
        
        int ans = dfs(0, 0, 0, record, s1, s2, x);

        // for(int i=0; i<record.length; i++){
        //     System.out.print(i + " ::: ");
        //     for(int j=0; j<record[0].length; j++){
        //         System.out.print(record[i][j][0] + ":" + record[i][j][1] + " ");
        //     }
        //     System.out.println();
        // }

        return ans;                       
    }

    // 当前位置，剩余额度，是否需要翻转
    public int dfs(int pos, int quato, int isRev, int[][][] record, String s1, String s2, int x){
        // 终点
        if(pos == s1.length()){
            if(isRev > 0 || quato > 0){
                return Integer.MAX_VALUE >> 1;
            }
            return 0;
        }

        // 已经搜过
        if(record[pos][quato][isRev] >= 0 ){
            return record[pos][quato][isRev];
        }

        // 若不需要翻转
        if((isRev==0 && s1.charAt(pos)==s2.charAt(pos)) || (isRev==1 && s1.charAt(pos)!=s2.charAt(pos))){
            return  record[pos][quato][isRev] = dfs(pos+1, quato, 0, record, s1, s2, x);
        }

        // 若需要翻转
        record[pos][quato][isRev] = Math.min(
            dfs(pos+1, quato, 1, record, s1, s2, x) + 1,    // 相邻翻转
            dfs(pos+1, quato+1, 0, record, s1, s2, x) + x); // 不相临翻转

        // 使用翻转额度
        if(quato > 0){
            record[pos][quato][isRev] = Math.min(record[pos][quato][isRev], dfs(pos+1, quato-1, 0, record, s1, s2, x));
        }
        
        return record[pos][quato][isRev];
    }
}
 