package KamaCoder.Issue098;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts;
        parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);
        int S = Integer.parseInt(parts[2]);

        double x1, y1, x2, y2, x3, y3;
        parts = br.readLine().split(" ");
        x1 = Double.parseDouble(parts[0]);
        y1=  Double.parseDouble(parts[1]);

        parts = br.readLine().split(" ");
        x2 = Double.parseDouble(parts[0]);
        y2=  Double.parseDouble(parts[1]);   

        parts = br.readLine().split(" ");
        x3=  Double.parseDouble(parts[1]);
        y3=  Double.parseDouble(parts[1]);

        double x0 = (x1 + x2 + x3) / 3;
        double y0 = (y1 + y2 + y3) / 3;
        boolean[] cmp = checkLine(x1, y1, x2, y2, x3, y3, x0, y0);
        int[] ans = new int[S*S+1];
        double width = 1.0 / S;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int cnt = 0;
                for(int xx=0; xx<S; xx++){
                    for(int yy=0; yy<S; yy++){
                        double x = i + xx * width + width / 2;
                        double y = j + yy * width + width / 2;
                        boolean[] res = checkLine(x1, y1, x2, y2, x3, y3, x, y);
                        boolean[] inline = checkInLine(x1, y1, x2, y2, x3, y3, x, y);
                        boolean flag = true;
                        for(int k=0; k<3; k++){
                            if(res[k] != cmp[k] && !inline[k]){
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag){
                            cnt++;
                            // System.out.println(i + " " + j + " " + x + " " + " " +  y);
                        }
                    }
                }
                ans[cnt]++;
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for(int cnt : ans){
            sj.add(Integer.toString(cnt));
        }
        bw.write(sj.toString());
        br.close();
        bw.close();
    }

    static boolean line(double x1, double y1, double x2, double y2, double x, double y){
        return (y1 - y2)*(x - x1) - (x1 - x2)*(y - y1) > 0;
    }

    static boolean inLine(double x1, double y1, double x2, double y2, double x, double y){
        return Math.abs((y1 - y2)*(x - x1) - (x1 - x2)*(y - y1)) < 1e-5;
    }

    static boolean[] checkLine(double x1, double y1, double x2, double y2, double x3, double y3, double x, double y){
        boolean[] res = new boolean[3];
        res[0] = line(x1, y1, x2, y2, x, y);
        res[1] = line(x2, y2, x3, y3, x, y);
        res[2] = line(x1, y1, x3, y3, x, y);
        return res;
    }

    static boolean[] checkInLine(double x1, double y1, double x2, double y2, double x3, double y3, double x, double y){
        boolean[] res = new boolean[3];
        res[0] = inLine(x1, y1, x2, y2, x, y);
        res[1] = inLine(x2, y2, x3, y3, x, y);
        res[2] = inLine(x1, y1, x3, y3, x, y);
        return res;
    }

}
