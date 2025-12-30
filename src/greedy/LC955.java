package greedy;

public class LC955 {
    public static void main(String[] args) {
        
    } 
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int cnt = 0;
        int[] status = new int[n];
        for(int j=1; j<n; j++){
            status[j] = -2;
        }
        for(int i=0; i<m; i++){
            boolean flag = true;
            for(int j=1; j<n; j++){
                if((status[j] == -2  || status[j] >= 0) && strs[j].charAt(i) < strs[j-1].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag){ // 记录相同的列
                for(int j=1; j<n; j++){
                    if((status[j] == -2 || status[j] >=0) && strs[j].charAt(i) == strs[j-1].charAt(i)){
                        status[j] = i;
                    }else{
                        status[j] = -1;
                    }
                    
                }
            }else{ 
                cnt++;
            }
        }
        return cnt;
    }
}
