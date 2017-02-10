import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	private Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

	public String toString() {
		String s = travel(this);
		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.poll();
			s += travel(n);
		}
		return s;
	}

	private String travel(UndirectedGraphNode input) {
		String s = input.label + "";
		for (UndirectedGraphNode n : input.neighbors) {
			if (!queue.contains(n) && n != input) {
				queue.offer(n);
			}
			s += "," + n.label;
		}
		s += "#";
		return s;
	}

	public static void main(String[] args) {
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		n0.neighbors.add(n0);
		n0.neighbors.add(n1);
		n0.neighbors.add(n2);
		n1.neighbors.add(n2);
		n2.neighbors.add(n2);
		System.out.println(n0.toString());
	}
}