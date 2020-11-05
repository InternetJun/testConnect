package corporation.daily;

import java.util.HashMap;


/**LRU的实现.
 * 双向的链表的实现
 * 最后的node的删除的实现问题是说。
 * 
 * */
public class LRUCache {

    // key -> Node(key, val) complex is O(1)。还有的是说
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {//不包含数据的意思
            if (cap == cache.size()) {
                // 删除链表最后一个数据,因为有要删除的是val和node 2个节点的问题了.
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
/*基本的node的节点.*/
    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    /*双向的链表实现.*/
    class DoubleList {
        private Node head, tail; // 头尾虚节点
        private int size; // 链表元素数

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 在链表头部添加节点 x
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
            /*
            * 双向链表的删除？自己的,有一定的规律的,不是说什么特殊的作用啊.
            * x.prev.next = x.next;
            * x.next.prev = x.prev;
            * */
        }

        // 删除链表中最后一个节点，并返回该节点?他的思想是很
        public Node removeLast() {
            if (tail.prev == head)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        // 返回链表长度
        public int size() {return size; }
    }

}

