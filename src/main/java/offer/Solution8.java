package offer;

import java.util.Stack;
/**
 * 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @date 2015-7-14
 */
public class Solution8 {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    public void push(int node) {
        s1.push(node);
    }
    
    public int pop() {
    	if(s2.isEmpty()) {
    		while(!s1.isEmpty()) {
    			s2.push(s1.pop());
    		}
    	}
    	return s2.pop();
    }
}