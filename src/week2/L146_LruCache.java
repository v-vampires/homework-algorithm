package week2;

import java.util.HashMap;
import java.util.Map;

public class L146_LruCache {
  public static void main(String[] args) {
      LRUCache lruCache = new L146_LruCache().new LRUCache(2);
      lruCache.put(1, 1); // 缓存是 {1=1}
      lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
      System.out.println(lruCache.get(1));    // 返回 1
      lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
      System.out.println(lruCache.get(2));    // 返回 -1 (未找到)
      lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
      System.out.println(lruCache.get(1));    // 返回 -1 (未找到)
      System.out.println(lruCache.get(3));    // 返回 3
      System.out.println(lruCache.get(4));    // 返回 4
  }
class LRUCache {

    private int capacity;

    private Map<Integer, Node> map;

    private DoubleNodeList doubleNodeList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleNodeList = new DoubleNodeList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return  -1;
        }
        final Node node = map.get(key);
        doubleNodeList.deleteNode(node);
        doubleNodeList.insertToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            final Node node = map.get(key);
            doubleNodeList.deleteNode(node);
        }
        final Node newNode = new Node(key, value);
        map.put(key, newNode);
        doubleNodeList.insertToHead(newNode);
        if(map.size() > capacity){
            Node node = doubleNodeList.deleteFromTail();
            map.remove(node.key);
        }

    }

    private class DoubleNodeList{
        private Node head;
        private Node tail;

        public DoubleNodeList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public void deleteNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void insertToHead(Node node) {
            //node与head的下一个的关系
            node.next = head.next;
            head.next.pre = node;
            //node与head的关系
            node.pre = head;
            head.next = node;
        }

        public Node deleteFromTail() {
            Node node = tail.pre;
            deleteNode(node);
            return node;
        }
    }


    private class Node{
        public int key;
        public int val;
        public Node pre;
        public Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}