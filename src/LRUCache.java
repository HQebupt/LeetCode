import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {

	LinkedHashMap<Integer, Integer> linkedmap;
	int maxCapacity;

	public LRUCache(int capacity) {
		this.maxCapacity = capacity;
		/*
		 *int capacity 容量
		 *int load factor 装载因子
		 *boolean accessOrder 是否访问顺序排序
		 */
		this.linkedmap = new LinkedHashMap<Integer, Integer>(capacity, 1f, true);
	}

	public int get(int key) {
		if (linkedmap.containsKey(key))
			return linkedmap.get(key);
		else
			return -1;
	}

	public void set(int key, int value) {
		int size = linkedmap.size();
		if ((size < maxCapacity) || (linkedmap.containsKey(key))) {
			linkedmap.put(key, value);
		} else if (size >= maxCapacity) {
			Iterator<Integer> it = linkedmap.keySet().iterator();
			linkedmap.remove(it.next());
			linkedmap.put(key, value);
		}
	}
}
/**
 * solution report: http://www.cnblogs.com/byrhuangqiang/p/3786105.html
 */ 