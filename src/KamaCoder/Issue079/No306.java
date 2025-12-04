package KamaCoder.Issue079;

import java.util.*;

public class No306 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            for(int i=0; i<n; i++){
                String s = sc.nextLine();
                System.out.println(decrypt(s));
            }
        } 
    }

    private static String decrypt(String s){
        char[] t = new char[s.length()];
        int index = 0;
        int p = 0;
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){ // 数字
                p = p * 10 + (c-'0');
                if(index > 0){
                    p %= index;
                }
            }else{ // 字母
                if(p!=0 && index>0){
                    char[] tmp = new char[s.length()];
                    for(int i=0; i<index; i++){
                        tmp[((i-p)+index)%index] = t[i]; 
                    }
                    for(int i=0; i<index; i++){
                        t[i] = tmp[i];
                    }
                }

                if(c == 'R'){
                    for(int i=0; i<index/2; i++){
                        char tmp = t[i]; 
                        t[i] = t[index-i-1]; 
                        t[index-i-1] = tmp;
                    }
                }else{
                    t[index++] = c;
                }
            }
        }

        return new String(t,0, index);
    }


}
