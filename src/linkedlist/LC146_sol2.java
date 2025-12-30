package linkedlist;

import java.util.LinkedHashMap;

public class LC146_sol2 {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        System.out.println(0);
        lru.put(1, 1);
        System.out.println(1);
        lru.put(2, 2);
        System.out.println(2);

        lru.get(1);
        System.out.println(3);

        lru.put(3, 3);
        System.out.println(4);

        lru.get(2);
        System.out.println(5);

        lru.put(4, 4);
        lru.get(1);
        lru.get(3);
        lru.get(4);
        
    }
    
}

class LRUCache {
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // print();
        if(map.containsKey(key)){
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // print();
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
        }else{
            if(map.size() < capacity){
                map.put(key, value);
            }else{
                map.remove(map.keySet().iterator().next());
                map.put(key, value);
            }
        }
        
    }
}
