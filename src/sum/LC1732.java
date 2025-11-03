package sum;

public class LC1732 {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;
        for(int i=0; i<gain.length; i++){
            altitude += gain[i];
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        LC1732 solution = new LC1732();
        int result = solution.largestAltitude(new int[]{-5, 1, 5, 0, -7});
        System.out.println(result);
    }
}

