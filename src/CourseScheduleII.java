import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class CourseScheduleII {
	// 内存溢出，将邻接矩阵改成邻接表
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[][] graph = new int[numCourses][numCourses];
		int[] in = new int[numCourses];
		for (int[] pair : prerequisites) {
			if (graph[pair[1]][pair[0]] == 0) {// 排除掉重复的输入。
				graph[pair[1]][pair[0]] = 1;
				in[pair[0]]++;
			}
		}
		Deque<Integer> dq = new LinkedList<Integer>();
		int[] res = new int[numCourses];
		return bfs(graph, in, numCourses, dq, res);
	}

	int[] bfs(int[][] graph, int[] in, int num, Deque<Integer> dq, int[] res) {
		int index = 0;
		int size = in.length;
		for (int i = 0; i < size; i++) {
			if (in[i] == 0) {
				dq.addLast(i);
			}
		}

		while (!dq.isEmpty()) {
			int v = dq.pop();
			res[index] = v;
			index++;
			for (int i = 0; i < num; i++) {
				if (graph[v][i] == 1) {
					in[i]--;
					if (in[i] == 0) {
						dq.addLast(i);
					}
				}
			}
		}
		return index < num - 1 ? new int[0] : res;
	}

	// Solution 2:
	// 不需要构造一遍图。上面的解法，由于构造图使用邻接矩阵导致了OOM
	// 内存溢出，将邻接矩阵改成邻接表，也无法通过。
	public int[] findOrder2(int numCourses, int[][] prerequisites) {
		int[] in = new int[numCourses];
		for (int[] pair : prerequisites) {
			in[pair[0]]++;
		}

		Deque<Integer> dq = new LinkedList<Integer>();
		int[] res = new int[numCourses];
		int index = 0;

		for (int i = 0; i < numCourses; i++) {
			if (in[i] == 0) {
				dq.addLast(i);
			}
		}

		while (!dq.isEmpty()) {
			int v = dq.pop();
			res[index++] = v;
			for (int[] pair : prerequisites) {
				if (pair[1] == v) {
					in[pair[0]]--;
					if (in[pair[0]] == 0) {
						dq.addLast(pair[0]);
					}
				}
			}
		}
		return index == numCourses ? res : new int[0];
	}

	public static void main(String[] args) {
		CourseScheduleII sol = new CourseScheduleII();
		int numCourses = 10;
		int[][] prerequisites = { { 5, 8 }, { 3, 5 }, { 1, 9 }, { 4, 5 },
				{ 0, 2 }, { 1, 9 }, { 7, 8 }, { 4, 9 } };
		System.out.println(Arrays.toString(sol.findOrder(numCourses,
				prerequisites)));
	}
}
