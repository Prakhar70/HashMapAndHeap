package Level2;

import java.util.HashMap;

public class Q047_LRUCache {
    private class KeyValue{
        int key;
        int value;
        KeyValue(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private class ListNode{
        KeyValue data;
        ListNode next;
        ListNode(KeyValue data){
            this.data = data;
            this.next = null;
        }
    }
    private class List{
        ListNode head = null;
        ListNode tail = null;
        public void addToLast(ListNode node){

        }
        public void removeANode(ListNode node){

        }
        public ListNode removeFirst(){
            return null;
        }
    }
    private HashMap<Integer, ListNode> map;
    private int size;
    private int capacity;
    private List list;

    public Q047_LRUCache(int capacity) {
        this.map = null;
        this.capacity = capacity;
        this.size = 0;
        this.list = new List();
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        KeyValue kv = new KeyValue(key, value);
        if(this.size == this.capacity){
            ListNode firstNode = list.removeFirst();
            map.remove(map.get(key));
            
        }
    }
}
