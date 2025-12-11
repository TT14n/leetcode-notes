package KamaCoder.Issue088;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.TreeSet;

public class No334 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int L = Integer.parseInt(parts[1]);
        // 0 表示 value
        // 1 表示 time
        TreeSet<int[]> set = new TreeSet<>((a, b) -> (a[1] - b[1]));
        HashMap<Integer, int[]> map = new HashMap<>(); 
        int time = 0;
        int cnt = 0;
        for(int i=0; i<L; i++){
            parts = br.readLine().split(" ");
            int key = Integer.parseInt(parts[1]);
            if(parts[0].equals("s")){ // 删除旧的，替换新的
                int value = Integer.parseInt(parts[2]);
                int[] ele = new int[]{value, time++};
                if(map.containsKey(key) && set.contains(map.get(key))){
                    set.remove(map.get(key));
                    cnt--;
                }else if(cnt == N){
                    set.pollFirst();
                    // int[] tmp =  set.pollFirst();
                    // bw.write(new String("delete: " + tmp[0] + " " + tmp[1]));
                    // bw.newLine();
                    // bw.write(Boolean.toString(set.contains(tmp)));
                    // bw.newLine();

                    cnt--;
                }
                map.put(key, ele);
                set.add(ele);
                cnt++;
            }else{ // 
                if(map.containsKey(key)){
                    int[] ele = map.get(key);
                    if(set.contains(ele)){
                        // System.out.println(key + " " + ele[0] + " " + ele[1]);
                        set.remove(ele);
                        ele[1] = time++;
                        set.add(ele);
                        bw.write(Integer.toString(ele[0]));
                        bw.newLine();
                    }else{ // 之前被删除了
                        bw.write(Integer.toString(-1));
                        bw.newLine();
                    }
                    
                }else{ // 未插入过
                    bw.write(Integer.toString(-1));
                    bw.newLine();
                }
            }
        }
        
        br.close();
        bw.close();
    }
    
}
