import java.util.*;

public class Baekjoon_15650 {
    static boolean[] visited;
    static int[] result;
    static int n;
    static int m;

    public static void dfs(int at, int depth) {
        if (depth == m) {
            // 깊이가 m이랑 같을 경우 출력
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        result = new int[m];

        dfs(1, 0);

        sc.close();
    }
}
