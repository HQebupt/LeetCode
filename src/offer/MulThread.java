package offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 多线程加锁，同步ArrayList。
 * 这个实例没有什么特别的，可忽略掉。
 * @date 2015-7-16
 */
public class MulThread {
	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		// add
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					synchronized (list) {
						list.add("a");
						if(list.size() == 200){
							System.out.println("add stop.");
							break;
						}
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		// remove
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					synchronized (list) {
						Iterator<String> it = list.iterator();
						while(it.hasNext()) {
							System.out.println(list.size());
							System.out.println("remove:" + it.next());
							it.remove();
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					}
				}
			}
		});
		a.start();
		b.start();
		try {
			Thread.sleep(1000*20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
