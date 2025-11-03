package simple;

public class LC165 {
    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        for(int i=0; i<Math.max(versions1.length, versions2.length); i++){
            if(i < versions1.length && i < versions2.length){
                int v1 = Integer.parseInt(versions1[i]);
                int v2 = Integer.parseInt(versions2[i]);
                if(v1 > v2) return 1;
                else if(v2 > v1) return -1;
            }else if(i < versions1.length){
                int v1 = Integer.parseInt(versions1[i]);
                if(v1 > 0) return 1;
            }else {
                int v2 = Integer.parseInt(versions2[i]);
                if(v2 > 0) return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LC165 sol = new LC165();
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(sol.compareVersion(version1, version2));
    }
}

