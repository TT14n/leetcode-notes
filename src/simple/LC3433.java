package simple;
import java.util.List;

public class LC3433 {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int time1 = Integer.parseInt(a.get(1));
            int time2 = Integer.parseInt(b.get(1));
            if(time1==time2){
                return b.get(0).compareTo(a.get(0));
            }else{
                return time1-time2;
            }

        });
        // System.out.println(events);
        int[] online = new int[numberOfUsers];
        int[] ans = new int[numberOfUsers];
        for(List<String> event : events){
            int time = Integer.parseInt(event.get(1));
            if(event.get(0).equals("MESSAGE")){ // MESSAGE
                if (event.get(2).equals("HERE")) {
                    for(int i=0; i< numberOfUsers; i++){
                        if(online[i] <= time){
                            ans[i]++;
                        }
                    }
                }else if(event.get(2).equals("ALL")){
                    for(int i=0; i< numberOfUsers; i++){
                            ans[i]++;
                    }
                }else{
                    String[] ids = event.get(2).split(" ");
                    for(int j=0; j<ids.length; j++){
                        int i = Integer.parseInt(ids[j].substring(2));
                        ans[i]++;
                    }
                }

            }else{ // OFFLINE
                int i = Integer.parseInt(event.get(2));
                online[i] = time + 60;
            }

            // System.out.println(event);
            // System.out.println(Arrays.toString(ans));
            // System.out.println(Arrays.toString(online));
        }
        return ans;
    }
}
