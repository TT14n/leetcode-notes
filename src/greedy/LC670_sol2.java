package greedy;

public class LC670_sol2 {
    public int maximumSwap(int num) {
        char[] s = Integer.toString(num).toCharArray();
        int maxIdx = s.length - 1;
        int p = -1, q = -1;
        for(int i = s.length - 2; i >= 0; i--){
            if(s[i] > s[maxIdx]){ // s[i] 是当前的最大数字
                maxIdx = i;
            }else if(s[i] < s[maxIdx]){ // s[i] 右边有比他大的数字
                p = i;
                q = maxIdx;
            }
        }

        if(p != -1){
            char tmp  = s[p]; s[p] = s[q]; s[q] = tmp;
        }
        return Integer.parseInt(new String(s));
    }
}

