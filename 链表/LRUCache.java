import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private DoubleList cache; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        } else {
            int res = map.get(key).val;
            put(key, res);
            return res;
        }
    }
    
    public void put(int key, int value) {
        Node x = new Node(key, value);

        if(map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if(capacity == cache.getSize()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}

class Node {
    public Node prev, next;
    public int key, val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    private int size = 0;

    private Node head = null;
    private Node tail = null;


    public void addFirst(Node x) {
        if(head == null) {
            head = x;
            tail = x;
        } else {
            Node temp = head;
            temp.prev = x;
            x.next = temp;
            head = x;
        } 
        size ++;      
    }

    public void remove(Node x) {
        if( x == head && x == tail) {
            head = null;
            tail = null;
        } else if (head == x) {
            Node temp = head.next;
            temp.prev = null;
            head = temp;
        } else if(x == tail) {
            Node temp = x.prev;
            temp.next = null;
            tail = temp;
        } else {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }
        size--;
    }

    public Node removeLast() {
        Node node = tail;
        this.remove(tail);
        return node;
    }

    public int getSize() {
        return size;
    }
}
