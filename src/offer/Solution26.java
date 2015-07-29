package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * 
 * 思路1：HashMap的使用，Time：O(n) Space:O(n) 借助于额外的HashMap，两次遍历可以解决。
 * 
 * 思路2：可以优化Space：O(1), 不借助于HashMap,需要三次遍历。 思路2的解法取巧，读起来很难懂。
 * 
 * 总结：虽然思路1，采用了HashMap，但是只是存储了引用，并没有带来空间的巨大消耗。
 * 
 * @date 2015-7-29下午12:28:52
 */
public class Solution26 {
	// Solution 1: 基本解法
	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	public RandomListNode clone(RandomListNode pHead) {
		RandomListNode dummy = new RandomListNode(-1);
		RandomListNode cur = pHead;
		RandomListNode tail = dummy;
		for (; cur != null; cur = cur.next) {
			RandomListNode node = new RandomListNode(cur.label);
			map.put(cur, node);
			tail.next = node;
			tail = node;
		}

		RandomListNode newCur = dummy.next;
		cur = pHead;
		for (; cur != null; cur = cur.next, newCur = newCur.next) {
			if (cur.random != null) {
				newCur.random = map.get(cur.random);
			}
		}

		return dummy.next;
	}

}