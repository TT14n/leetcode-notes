package search;


import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class LC765 {
    private int[][] group = new int[36][6];
    private int[] len = new int[36];
        
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(String s : allowed){
            int idx = trans(s.charAt(0), s.charAt(1));
            group[idx][len[idx]++] = s.charAt(2);
        }        
        
        int n = bottom.length();
        char[][] res = new char[n][n];
        Set<String> vis = new HashSet<>(); 
        for(int i=0; i<n; i++){
            res[n-1][i] = bottom.charAt(i);
        }

        for(char c='A'; c<='F'; c++){
            if(dfs(n-2, 0, c, res, vis)){
                return true;
            }
        }
        return false;
    }

    boolean dfs(int row, int col, char c, char[][] res, Set<String> vis){
        int idx1 = trans(res[row+1][col], res[row+1][col+1]);
        if(!find(group[idx1], len[idx1], c)){
            return false;
        }

        if(row==0 && col==0){
            return true;
        }

        if(col > 0){
            int idx2 = trans(res[row][col-1], c);
            if(len[idx2] == 0){
                return false;
            }
        }

        res[row][col] = c;


        // 检索局部情况是否被遍历过了，>=3 长度的才被检索
        for(int j=0; j<col-1; j++){
            String str = new String(res[row], j, col-j+1);
            if(vis.contains(str)){
                return false;
            }
        }



        int nx_row, nx_col;
        if(col == row){
            nx_col = 0;
            nx_row = row - 1;
            if(!vis.add(new String(res[row]))){ // 这一行之前填过一模一样的，继续填，没能填到塔顶
                return false;
            }
        }else{
            nx_col = col + 1;
            nx_row = row;
        }
        for(char nx='A'; nx<='F'; nx++){
            if(dfs(nx_row, nx_col, nx, res, vis)){
                return true;
            }
        }

        return false;
    }



    private int trans(char a, char b){
        return (a-'A')*6+(b-'A');
    }
    
    private boolean find(int[] str, int len, char c){
        for(int i=0; i<len; i++){
            if(c == str[i]){
                return true;
            }
        }
        return false;
    }


}