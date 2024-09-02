<<<<<<< HEAD
import java.util.*;

public class Baekjoon_1260 {
    static int[][] graph;
    static int size;
    static int edge;
    static int start;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i <= size; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");
            
            for (int i = 1; i <= size; i++) {
                if (!visited[i] && graph[temp][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        edge = sc.nextInt();
        start = sc.nextInt();
        graph = new int[size + 1][size + 1];
        visited = new boolean[graph.length];


        for (int i = 0; i < edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(start);
        System.out.println();
        visited = new boolean[graph.length];
        bfs(start);

        sc.close();
=======
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
>>>>>>> 7c8416ac8b417fed1a12a103e7fd0ab686b56eaa
        
    }
}
