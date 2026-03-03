package hash;

public class LC215_sol1 {
    public int findKthLargest(int[] nums, int k) {
        int[] bucket = new int[20000+1];
        int maxNum = -10000;
        int minNum = 10000;
        int BASE = 10000;
        for(int num : nums){
            bucket[num + BASE]++;
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }

        for(int i=maxNum+BASE; i>=minNum+BASE; i--){
            k -= bucket[i];
            if(k <= 0){
                return i-BASE;
            }
        }

        return -1;

    }
}
