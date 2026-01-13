package KamaCoder.Issue090;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class No338 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            t--;
            int ans = 0;
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(char c : str.toCharArray()){
                if(c == '{' || c == '['){
                    stack.push(c);
                }else{
                    char left = stack.pop();
                    if((left == '{' && c == '}') || (left == '[' && c ==']')){
                        continue;
                    }
                    ans++;
                }
            }
            bw.write(Integer.toString(ans));
            bw.newLine();
        }


        br.close();
        bw.close();
    }
}
