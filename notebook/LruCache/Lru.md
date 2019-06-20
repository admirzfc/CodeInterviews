# LruCache

### Question of LRU

�������ʹ�ã�LRU�����淽�����ڻ�������������Ҫ���½���ʹ�õ���Ŀ���ӵ�����ʱ���ȶ����������ʹ�õ���Ŀ��������ʹ��LinkedHashMap��
���һ��ʵ�����½ӿڵ�LRU���淽����

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

��һ��HashMap+˫���������洢��Ŀ��ʹ��ʱ���Ⱥ��ϵ�������Ŀ��ʹ�������������β����������������£�������������Ŀ������λ�õĽڵ�ɾ���������²������Ŀ��������β
���ǵ���������synchronized���η�����֤Put�����̰߳�ȫ



代码：

[LruCache](LruCache.java)

[LruCacheTest](LruCacheTest.java)
