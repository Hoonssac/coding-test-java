import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Baekjoon_1260_1 {
    static int[][] map;
    static boolean[] visited;
    static int N,M,V;

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 1; i <= N; i++) {
            if (map[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        // 노드 입력
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            map[start][end] = 1;
            map[end][start] = 1;
        }

        // dfs
        dfs(V);
        System.out.println();

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N+1];
        queue.add(V);
        visited[V] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i = 1; i <= N; i++) {
                if (map[i][node] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();

        sc.close();
    }
}
