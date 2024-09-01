import java.util.Scanner;

public class Baekjoon_1260 {
	static int[][] graph;
	static boolean[] visited;
	static int size;
	static int start;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] setting = sc.nextLine().split(" ");
		size = Integer.parseInt(setting[0]);
		start = Integer.parseInt(setting[2]);
		graph = new int[size + 1][size + 1];
		visited = new boolean[size + 1];
		
		// 그래프 입력
		for (int i = 0; i < Integer.parseInt(setting[1]); i++) {
			String[] input = sc.nextLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		dfs(start);
		sc.close();
	}
	
	static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " ");
		
		for (int i = 1; i <= size; i++) {
			if (!visited[i] && graph[node][i] == 1) {
				dfs(i);
			}
		}
	}

    static void bfs(int node) {
        
    }
}
