package LruCacheDeal;

import java.util.HashMap;

public class LruCache<K,V> {

/**
 * @Description: （LRU）
 * Created by zfc114380@163.com on 2019/03/26-22:55.
 * @version 1.0
 */

    /** 定义双链表节点 */
    class LruNode<K,V>{

        LruNode<K,V> prev;//前驱
        LruNode<K,V> next;//后继
        private K key;
        private V value;

        public LruNode(LruNode<K,V> prev, LruNode<K,V> next, K key, V value) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 0;//Set size
    private int currentSize;//已使用size
    private LruNode head;//双链表头结点代表最近最少使用
    private LruNode last;//双链表为节点代表最近最多使用
    private HashMap<K,LruNode<K, V>> nodes;


    /** 初始化 */
    public void setCapacity(int capacity) {
        if(capacity > 0){
            this.capacity = capacity;
        }
        currentSize = 0;
        last = new LruNode<K,V>(null, null, null, null);
        head = last;
        nodes = new HashMap<K, LruNode<K, V>>(capacity);
    }

    /** 查询Cache，刷新使用时间 */
    public V get(K key){
        LruNode<K, V> node = nodes.get(key);
        if (node == null){
            return null;
        } else if (node.key == last.key){
            return node.value;
        }

        LruNode<K, V> nextNode = node.next;
        LruNode<K, V> previousNode = node.prev;

        if (node.key == head.key){
            /** 如果Get节点是头结点，更新其后继结点为头结点 */
            nextNode.prev = null;
            head = nextNode;
        } else{
            /** 如果Get节点不是尾结点，将该节点移到链尾 */
            previousNode.next = nextNode;
            nextNode.prev = previousNode;
        }
        /** 重置链尾节点 */
        node.prev = last;
        last.next = node;
        last = node;
        last.next = null;

        return node.value;
    }

    public synchronized void put(K cacheKey, V cacheValue) {

        if (nodes.containsKey(cacheKey)){
            return;
        }
        /** 这里不清楚重新set一个项目是否要刷新其使用时间，若刷新则为如下注释代码 */
//        if (nodes.containsKey(cacheKey)){
//            get(cacheKey);
//            return;
//        }

        /** 插入节点放置链尾 */
        LruNode<K, V> node = new LruNode<K, V>(last, null, cacheKey, cacheValue);
        last.next = node;
        nodes.put(cacheKey, node);
        last = node;

        /** 丢弃头结点 */
        if (currentSize == capacity){
            nodes.remove(head.key);
            head = head.next;
            head.prev = null;
        }

        else if (currentSize < capacity){
            if (currentSize == 0){
                head = node;
            }
            currentSize++;
        }
    }
}

