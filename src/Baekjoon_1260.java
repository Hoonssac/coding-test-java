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
        
    }
}
