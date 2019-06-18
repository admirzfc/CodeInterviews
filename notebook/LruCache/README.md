# LruCache
### Question of LRU

最近最少使用（LRU）缓存方案是在缓存已满并且需要将新近被使用的项目添加到缓存时首先丢弃最近最少使用的项目。（不能使用LinkedHashMap）
设计一个实现以下接口的LRU缓存方案。

    public interface LruCache<K, V> {
         /** Set the capacity of the total cache num */
        void setCapacity(int capacity);

         /**
         * Update cache according to LRU definition.
         * This time complexity of this method should be O(1).
         */
         void put(K cacheKey, V cacheValue);
    }
### 思路

用一个HashMap+双向链表来存储项目的使用时间先后关系，如果项目被使用则将其放置在链尾，链表已满的情况下，若继续添加项目则将链首位置的节点删除，并将新插入的项目放置在链尾
考虑到并发，用synchronized修饰符来保证Put操作线程安全