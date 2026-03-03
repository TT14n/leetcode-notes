package KamaCoder.Issue096;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class VersionNode {
    public VersionNode(int cnt, String preVersion){
        this.cnt = cnt;
        this.preVersion = preVersion;
    }
    int cnt;
    String preVersion;    
}
public class No353 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        HashMap<String, VersionNode> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            String[] strs = br.readLine().split(" ");
            VersionNode node = new VersionNode(-1, strs[1]);
            map.put(strs[0], node);
        }

        int length = -1;
        ArrayList<String> longestVersionArray = new ArrayList<>();
        for(String version : map.keySet()){
            VersionNode node = map.get(version);
            dfs(map, node);
            if(node.cnt > length){
                length = node.cnt;
                longestVersionArray.clear();
                longestVersionArray.add(version);
            }else if(node.cnt == length){
                longestVersionArray.add(version);
            }
        }

        Collections.sort(longestVersionArray);
        for(int i=0; i<longestVersionArray.size(); i++){
            bw.write(longestVersionArray.get(i));
            bw.write(" ");
        }

        br.close();
        bw.close();


    }

    // 找到有多少个前序版本
    static int dfs(HashMap<String, VersionNode> map, VersionNode node){
        // 找过一遍，不找了
        if(node.cnt != -1){
            return node.cnt;
        }

        // 没有前序版本，返回 0
        if(node.preVersion.equals("NA")){
            return 0;
        }

        // 尝试遍历前序版本，并更新 node.cnt
        VersionNode preNode = map.get(node.preVersion);
        node.cnt = dfs(map, preNode) + 1;
        return node.cnt;

    }
}
