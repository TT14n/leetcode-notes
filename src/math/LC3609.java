package math;

public class LC3609 {

    public static void main(String[] args) {
        LC3609 solution = new LC3609();
        System.out.println(solution.minMoves(0, 1, 1000000000, 999999999));
        
    }
    public int minMoves(int sx, int sy, int tx, int ty) {
        // 递推，反向思考
        // 当 xi > yi 时, j = i-1 有
        // (xi, yi) = (2xj, yj)     此时 xi/2 >= yj
        // (xi, yi) = (xj+yj, yj)   此时 xi/2 <= yj
        int ans = 0;
        while(tx != sx || ty != sy){
            ans++;
            if(tx < ty){
                int tmp;
                tmp = tx; tx = ty; ty = tmp;
                tmp = sx; sx = sy; sy = tmp;
            }
            // 保证 tx >= ty，简化思考逻辑
            // tx == ty，只可能 y = 0;（或是 x = 0, 但是我们这里尽量 x > y）
            if(tx == ty){
                if(sx == 0){
                    tx = 0;
                }else{
                    ty = 0;
                }
            }else{
                if(tx/2 >= ty){ // (xi, yi) = (2xj, yj)
                    if(tx % 2 == 1){
                        ans = -1;
                        break;
                    }
                    tx = tx / 2;
                }else{ // (xi, yi) = (xj+yj, yj)
                    tx = tx - ty; 
                    if(ty == 0){
                        ans = -1;
                        break;
                    }
                }
            }
            // System.out.println(sx + " " + sy + " " + tx + " " + ty);
        }
        return ans;   
    }
}