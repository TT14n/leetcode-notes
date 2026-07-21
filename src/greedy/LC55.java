package greedy;

class LC55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n){
            int maxPos = i;
            int nextPos = i;
            for(int j=i+1; j<=Math.min(i+nums[i], n-1); j++){
                if(j + nums[j] > maxPos){
                    maxPos = j + nums[j];
                    nextPos = j;
                }
            }
            if(i == nextPos){
                return false;
            }
            i = nextPos;
        }

        return true;
    }
}
