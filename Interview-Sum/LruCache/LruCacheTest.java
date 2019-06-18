package LruCacheDeal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LruCacheTest {

    @Test
    void test() {
        LruCache lruCache =  new LruCache();
        lruCache.setCapacity(3);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
//        lruCache.put(2, 1);
        lruCache.get(2);
        lruCache.put(3, 1);
        lruCache.put(4, 1);
        assertNull(lruCache.get(1));
        assertEquals(lruCache.get(2),1);
    }
}