package heap;

import java.util.HashMap;
import java.util.TreeSet;

public class LC2349_Solution2 {
    static class NumberContainers {
    // index -> number
    HashMap<Integer, Integer> numberMap;
    // number -> order set
    HashMap<Integer, TreeSet<Integer>> setMap;
    public NumberContainers() {
        numberMap = new HashMap<>();
        setMap = new HashMap<>();
    }

    public void change(int index, int number) {
        int oldNumber = numberMap.getOrDefault(index, 0);
        if(oldNumber > 0) setMap.get(oldNumber).remove(index);
        numberMap.put(index, number);
        // 创建有序集合
        setMap.putIfAbsent(number, new TreeSet<>());
        setMap.get(number).add(index);

        // 输出所有集合的内容
//        System.out.println("change: " + index + " " + number);
//        for (HashMap.Entry<Integer, TreeSet<Integer>> entry : setMap.entrySet()){
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

    }

    public int find(int number) {
        if(setMap.containsKey(number)){
            TreeSet<Integer> set = setMap.get(number);
            if(!set.isEmpty()) return set.first();
        }
        return -1;
    }
    }
    
    public static void main(String[] args) {
        NumberContainers obj = new NumberContainers();
        obj.change(2, 3);
        obj.change(1, 2);
        obj.change(10, 2);
        System.out.println(obj.find(2));
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

