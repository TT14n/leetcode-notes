package math;

public class LC3577 {

    public int countPermutations(int[] complexity) {
        // (n-1)!
        int mod = 10_0000_0000 + 7;
        int n = complexity.length;
        long ans = 1;
        for(int i=1; i<n; i++){
            if(complexity[i] <= complexity[0]){
                return 0;
            }
            ans = ans * i % mod;
        } 

        return (int)ans;
    }
}