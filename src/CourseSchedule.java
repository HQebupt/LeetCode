import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
	// 拓扑排序
	// Time:O(m + n) Space:O(图的邻接矩阵）
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] graph = new int[numCourses][numCourses];
		for (int[] arr : prerequisites) {
			graph[arr[1]][arr[0]] = 1;
		}

		// 1.mark all nodes unexplored
		int[] visited = new int[numCourses];
		// 2.currentLabel = n - 1
		// 3. loop
		for (int node = 0; node < numCourses; node++) {
			if (visited[node] == 0) {
				if (!dfs(graph, node, visited)) {
					return false;
				}
			}
		}
		return true;
	}

	boolean dfs(int[][] graph, int s, int[] visited) {
		// 1. mark s explored
		visited[s] = 1; // 0/1/2 no visit/visiting/visited
		// 2. for every edge(s,v)
		int len = graph[s].length;
		for (int i = 0; i < len; i++) {
			if (graph[s][i] == 1) {
				if (visited[i] == 1) {
					return false;
				} else if (visited[i] == 0) {
					if (!dfs(graph, i, visited)) {
						return false;
					}
				}
			}
		}
		// 3.set f(s) = currentLable
		// 4.currentLable--
		visited[s] = 2;
		return true;
	}
	
	
	
	// Solution 2: BFS
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		int[][] graph = new int[numCourses][numCourses];
		int[] in = new int[numCourses];
		for (int[] pair : prerequisites) {
			if (graph[pair[1]][pair[0]] == 0) {// 排除掉重复的输入。
				graph[pair[1]][pair[0]] = 1;
				in[pair[0]]++;
			}
		}
		Deque<Integer> dq = new LinkedList<Integer>();
		return bfs(graph, in, numCourses, dq, null);
	}

	boolean bfs(int[][] graph, int[] in, int num, Deque<Integer> dq,
			List<Integer> res) {
		int size = in.length;
		for (int i = 0; i < size; i++) {
			if (in[i] == 0) {
				dq.addLast(i);
			}
		}

		while (!dq.isEmpty()) {
			int v = dq.pop();
			res.add(v);
			for (int i = 0; i < graph[v].length; i++) {
				if (graph[v][i] == 1) {
					in[i]--;
					if (in[i] == 0) {
						dq.addLast(i);
					}
				}
			}
		}

		for (int degree : in) {
			if (degree != 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		CourseSchedule sol = new CourseSchedule();
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(sol.canFinish(numCourses, prerequisites ));
	}
}