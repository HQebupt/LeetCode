import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {

	LinkedHashMap<Integer, Integer> map;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		/*
		 *int capacity 容量
		 *int load factor 装载因子
		 *boolean accessOrder 是否访问顺序排序
		 */
		this.map = new LinkedHashMap<Integer, Integer>(capacity, 1f, true);
	}

	public int get(int key) {
		if (map.containsKey(key))
			return map.get(key);
		else
			return -1;
	}

	public void set(int key, int value) {
		int size = map.size();
		if ((size < capacity) || (map.containsKey(key))) {
			map.put(key, value);
		} else if (size >= capacity) {
			Iterator<Integer> it = map.keySet().iterator();
			map.remove(it.next());
			map.put(key, value);
		}
	}
}
/**
 * solution report: http://www.cnblogs.com/byrhuangqiang/p/3786105.html
 */ 