package linkedlist;

import java.util.HashMap;

public class LC146_sol1 {
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
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int len = 0;
    private int capacity;

    class Node{
        private int val;
        private int key;
        private Node pre;
        private Node next;
        
        public Node(){
        }

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    private void print(){
        Node node = head;
        while (node.next.next != null) {
            node = node.next;
            System.out.print(node.val + " ");
        }
        System.out.println();
    }
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // print();
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // print();
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.val = value;
            add(node);
        }else{
            Node node = new Node(key, value);
            map.put(key, node);
            if(len < capacity){
                add(node);
            }else{
                map.remove(head.next.key);
                remove(head.next);
                add(node);
            }
        }
        
    }

    private void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.pre = null;
        node.next = null;
        
        len--;
    }
    
    private void add(Node node){
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
        len++;
    }
}
