import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for undirected graph. class UndirectedGraphNode { int label;
 * List<UndirectedGraphNode> neighbors; UndirectedGraphNode(int x) { label = x;
 * neighbors = new ArrayList<UndirectedGraphNode>(); } };
 */

public class CloneGraph {

	// BFS Time:O(n) Space:O(n)
	private Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		map.put(node, head);
		queue.offer(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode curr = queue.poll();
			for (UndirectedGraphNode n : curr.neighbors) {
				if (map.containsKey(n)) {
					map.get(curr).neighbors.add(map.get(n));
				} else {
					UndirectedGraphNode tmp = new UndirectedGraphNode(n.label);
					map.put(n, tmp);
					queue.offer(n);
					map.get(curr).neighbors.add(tmp);
				}
			}
		}
		return head;
	}
	

	// DFS Time:O(n) Space:O(n)
	Map<UndirectedGraphNode, UndirectedGraphNode> copied = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		clone(node, copied);
		return copied.get(node);
	}

	private UndirectedGraphNode clone(UndirectedGraphNode node,
			Map<UndirectedGraphNode, UndirectedGraphNode> copied) {
		if (copied.containsKey(node))
			return copied.get(node);
		UndirectedGraphNode tmp = new UndirectedGraphNode(node.label);
		copied.put(node, tmp);
		for (UndirectedGraphNode n : node.neighbors) {
			tmp.neighbors.add(clone(n, copied));
		}
		return copied.get(node);
	}

	// main method
	public static void main(String[] args) {
		CloneGraph sol = new CloneGraph();
		UndirectedGraphNode n0 = new UndirectedGraphNode(0);
		UndirectedGraphNode n1 = new UndirectedGraphNode(-1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(-2);
		n0.neighbors.add(n0);
		n0.neighbors.add(n1);
		n0.neighbors.add(n2);
		n1.neighbors.add(n2);
		n2.neighbors.add(n2);
		System.out.println("res:" + sol.cloneGraphDFS(n0));
	}

}