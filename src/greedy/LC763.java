package greedy;

import java.util.*;

public class LC763 {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] pos = new int[26]; // 记录最后出现的位置
        for(int i=0; i<n; i++){
            pos[chars[i] - 'a'] = i;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int l = 0;
        int minI = 0;
        while (i < n){
            // 贪心获得一轮的最小长度
            while (i <= minI){
                minI = Math.max(minI, pos[chars[i] - 'a']);
                i++;
                l++;
            }

            ans.add(l);
            // 下一轮
            l = 0;
            minI = i;
        }

        return ans;

    }
}
