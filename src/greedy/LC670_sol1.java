package greedy;

public class LC670_sol1 {
    public int maximumSwap(int num) {
        int[] a = new int[10];
        int cnt = 0;
        int x = num;
        while (x != 0) {
            a[cnt] = x % 10;
            x /= 10;
            cnt++;
        }

        int ans = num;
        for(int i=0; i<cnt; i++){
            for(int j=i+1; j<cnt; j++){
                if(a[j] < a[i]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;

                    int newNum = 0;
                    for(int k=cnt-1; k>=0; k--){
                        newNum = newNum * 10 + a[k];
                    }
                    // System.out.println(newNum);
                    if(newNum > ans){
                        ans = newNum;
                    }
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        } 
        return ans;
    }
}

