import java.util.*;

public class Baekjoon_2606 {
	static int[][] graph;
	static boolean[] visited;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = sc.nextInt();
		int edge = sc.nextInt();
		
		graph = new int[count+1][count+1];
		visited = new boolean[count+1];
		
		// 그래프 입력
		for (int i = 0; i < edge; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		queue.add(1);
		visited[1] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 1; i <= count; i++) {
				if (!visited[i] && graph[now][i] == 1) {
					queue.add(i);
					visited[i] = true; // 방문 여부 표시
					answer++;
				}
			}
		}
		
		
		System.out.println(answer);
		sc.close();
		
	}
}
