package KamaCoder.Issue097;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Element {
    int x, y, step;

    public Element(int x, int y, int step){
        this.x = x;
        this.y = y;
        this.step = step;
    }

    public ArrayList<Element> nextElements(int n){
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        ArrayList<Element> arr = new ArrayList<>();
        for(int i=0; i<4; i++){
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if(nx >= 0 && nx < n && ny >=0 && ny < n){
                arr.add(new Element(nx, ny, step+1));
            }
        }
        return arr;
    }
    
}

public class No358 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        int[][] steps = new int[n][n];
        for(int i=0; i<n; i++){
            String[] parts = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                steps[i][j] = -1;
                matrix[i][j] = Integer.parseInt(parts[j]);
            }
        }

        // bfs
        Queue<Element> q = new ArrayDeque<>();
        q.add(new Element(0, 0, 0)); 
        steps[0][0] = 0;
        int ans = -1;
        while (!q.isEmpty()) {
            Element e = q.poll();
            if(e.x == n-1 && e.y == n-1){
                ans = e.step;
                break;
            }

            for(Element ne : e.nextElements(n)){
                if(matrix[ne.x][ne.y] == 1 && (steps[ne.x][ne.y] == -1 || ne.step < steps[ne.x][ne.y])){
                    steps[ne.x][ne.y] = ne.step;
                    q.add(ne);
                }
            }
        }
        

        bw.write(Integer.toString(ans));
        bw.newLine();

        br.close();
        bw.close();
    }
}
