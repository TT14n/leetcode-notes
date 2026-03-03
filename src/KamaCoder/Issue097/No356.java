package KamaCoder.Issue097;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringJoiner;

public class No356 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = br.readLine().split(",");
        int n = parts.length;
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(parts[i]);
        }

        int[] array = new int[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int len = 0;
        for(int i=0; i<n; i++){
            boolean check = false;
            for(int j=0; j<len; j++){
                if(array[j] > nums[i]){
                    array[j] = nums[i];
                    list.get(j).add(nums[i]);
                    check = true;
                    break;
                }
            }
            if(!check){
                array[len++] = nums[i];
                ArrayList<Integer> newArr = new ArrayList<>();
                newArr.add(nums[i]);
                list.add(newArr);
            }
        }

        bw.write(Integer.toString(len));
        bw.newLine();
        for(int i=0; i<len; i++){
            StringJoiner sj = new StringJoiner(",");
            for(int num : list.get(i)){
                sj.add(Integer.toString(num));
            }
            bw.write(sj.toString());
            bw.newLine();
        }

        br.close();
        bw.close();


    }
}
