// 연결 요소의 개수
import java.util.Scanner;

public class Baekjoon_11724 {
    static int n;
    static int m;
    static int[][] graph;
    static boolean[] visited;
    static int answer;

    private static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        answer = 0;
        
        // 무방향 그래프 입력
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        // dfs
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        // 결과 출력
        System.out.println(answer);
        
        sc.close();
    }
}
