import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointer {
	//better solution.Time:O(n),Space:O(1)
	public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode cur = head;
    	while(cur != null) {
    		RandomListNode node = new RandomListNode(cur.label);
    		node.next = cur.next;
    		cur.next = node;
    		cur = node.next;
    	}
    	cur = head;
    	while(cur != null) {
    		if(cur.random != null){
    			cur.next.random = cur.random.next;
    		}
    		cur = cur.next.next;
    	}
    	cur = head;
    	RandomListNode dummy = new RandomListNode(-1);
    	RandomListNode newCur = dummy;
    	while(cur!= null) {
    		newCur.next = cur.next;
    		newCur = newCur.next;
    		cur.next = cur.next.next;
    		cur = cur.next;
    	}
    	return dummy.next;
    }
	
	//basic solution. Time:O(n),Space:O(n)
	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	public RandomListNode copyRandomList2(RandomListNode head) {
    	RandomListNode cur = head;
    	RandomListNode dummy = new RandomListNode(-1);
    	RandomListNode tail = dummy;
    	while(cur != null) {
    		RandomListNode node = new RandomListNode(cur.label);
    		map.put(cur, node);
    		tail.next = node;
    		tail = node;
    		cur = cur.next;
    	}
    	cur = head;
    	RandomListNode newCur = dummy.next;
    	while(cur != null) {
    		if(cur.random != null) {
    			newCur.random = map.get(cur.random);
    		}
    		cur = cur.next ;
    		newCur = newCur.next ;
    	}
    	return dummy.next;
	}
	
	public static void main(String[] args) {
		CopyListwithRandomPointer sol = new CopyListwithRandomPointer();
		RandomListNode a1 = new RandomListNode(1);
		RandomListNode a2 = new RandomListNode(2);
		RandomListNode a3 = new RandomListNode(3);
		RandomListNode a4 = new RandomListNode(4);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		RandomListNode res = sol.copyRandomList2(a1);
		System.out.println(res);
	}
	
	
	
	
	
	
	
	
	
}