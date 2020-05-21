package alg;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUMap extends LinkedHashMap {

    private final int max;
    private final Object lock;

    public LRUMap(int max, Object lock) {
        //无需扩容
        super((int) (max * 1.4f), 0.75f, true);//1.4*0.75 = 1.05才会扩容
        this.max = max;
        this.lock = lock;
    }

    /**
     * 重写LinkedHashMap的removeEldestEntry方法(回调函数)即可
     * 在Put的时候判断，如果为true，就会删除最老的
     * 下面的removeEldestEntry方法中只需要size>max就淘汰，这样我们这个map永远也走不到扩容的逻辑了
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > max;
    }

    public Object getValue(Object key) {
        synchronized (lock) {
            return get(key);
        }
    }
    public void putValue(Object key, Object value) {
        synchronized (lock) {
            put(key, value);
        }
    }

    public boolean removeValue(Object key) {
        synchronized (lock) {
            return remove(key) != null;
        }
    }
    public boolean removeAll(){
        clear();
        return true;
    }
}
