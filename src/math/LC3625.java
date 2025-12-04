package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LC3625 {
    public static void main(String[] args) {
        LC3625 solution = new LC3625();
        System.out.println(solution.countTrapezoids(new int[][]{{71,-89},{-75,-89},{-9,11},{-24,-89},{-51,-89},{-77,-89},{42,11}}));
    }

    public int countTrapezoids(int[][] points) {
        HashMap<Slope, HashMap<Integer, Integer>> slopes = new HashMap<>();
        HashMap<Integer, HashMap<Slope, Integer>> diags = new HashMap<>();
        int n = points.length;
        for(int i=0; i<n; i++){
            int x1 = points[i][0], y1 = points[i][1];
            for(int j=i+1; j<n; j++){
                int x2 = points[j][0], y2 = points[j][1];
                Slope slope = new Slope(x1-x2, y1-y2);

                int inte = slope.intercept(x1, y1);
                HashMap<Integer, Integer> cnts1 = slopes.computeIfAbsent(slope, key -> new HashMap<>());
                // cnts.put(inte, cnts.getOrDefault(inte, 0)+1);
                cnts1.merge(inte, 1, (old, val) -> old + val);

                // 中点：(x1,y1),(x2,y2) -> ((x1+x2)/2, (y1+y2)/2)
                // 为了避免浮点数，并且用一个数表示
                int mid = (x1+x2+2000)*4000 + (y1+y2+2000); 
                HashMap<Slope, Integer> cnts2 = diags.computeIfAbsent(mid, key -> new HashMap<>());
                cnts2.merge(slope, 1, (old, val) -> old + val); 
            }
        }

        // 统计平行梯形（存在重复的平行四边形）
        int ans = 0;
        for(Slope s : slopes.keySet()){
            int sum = 0;
            HashMap<Integer, Integer> cnts = slopes.get(s);
            // System.out.println(s.x + " " + s.y + " " + cnts);
            for(int key : cnts.keySet()){
                int cnt = cnts.get(key);
                ans += sum * cnt;
                sum += cnt;
            }
        }

        // 统计平行四边形
        int diff = 0;
        for(Integer mid : diags.keySet()){
            int sum = 0;
            HashMap<Slope, Integer> cnts = diags.get(mid);
            for(Slope s : cnts.keySet()){
                int cnt = cnts.get(s);
                diff += sum * cnt;
                sum += cnt;
            }
        }
        return ans-diff;
    }

    class Slope {
        private int x;
        private int y;
        public Slope(int x, int y){
            // 斜率 k = y/x
            // 特殊情况，垂直(x=0)和平行(y=0)
            // 用 x=0,y=1 唯一表示垂直时候的斜率
            // 用 x=1,y=0 唯一表示平行时候的斜率
            if(y==0){
                x=1;
            }else if(x==0){
                y=1;
            }else{
                int g = gcd(x,y);
                x = x / g;
                y = y / g;
                // 如果有一个负数，统一让 x 作为负数
                if(x > 0 && y < 0){
                    x = -x;
                    y = -y;
                }
            }
            
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || !(o instanceof Slope)) return false;
            Slope s = (Slope) o;
            return this.x == s.x && this.y == s.y; 
        }
        
        static int gcd(int a, int b){
            if(a % b == 0){
                return b;
            }
            return gcd(b, a%b);
        }
    
        int intercept(int x1, int y1){
            return y1*this.x - x1*this.y;
        }
    }
    
}
