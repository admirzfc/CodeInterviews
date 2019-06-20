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

### ˼·



代码：

[LruCache](LruCache.java)

[LruCacheTest](LruCacheTest.java)
