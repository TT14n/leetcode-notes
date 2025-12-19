  class Trie {
    class Node{
        boolean exist;
        Node[] childs = new Node[26];
    }
    
    Node head;
    public Trie(){
        head = new Node();
    }
    
    public void insert(String word) {
        Node node = head;
        for(char c : word.toCharArray()){
            int val = c-'a';
            if(node.childs[val] == null){
                node.childs[val] = new Node(); 
            }  
            node = node.childs[val];
        }
        node.exist = true;
    }
    
    public boolean search(String word) {
        return this.find(word) == 1;
    }
    
    public boolean startsWith(String prefix) {
        return this.find(prefix) != -1;
    }

    private int find(String word){
        // 1 表示完全匹配，0表示部分匹配，-1表示不匹配
        Node node = head;
        for(char c : word.toCharArray()){
            int val = c-'a';
            if(node.childs[val] == null){
                return -1;
            }  
            node = node.childs[val];
        }
        if(node.exist){
            return 1;
        }else{
            return 0;
        }
        
    }
}
