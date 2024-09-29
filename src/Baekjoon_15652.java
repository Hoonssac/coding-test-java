import java.util.*;

public class Baekjoon_15652 {
    static boolean[] visited;
    static int[] result;
    static int n;
    static int m;

    static void dfs(int at, int depth) {
        if (depth == m) {
            for (int i:result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;

        }
        for (int i = at; i <= n; i++) {
            if (!visited[i]) {
                result[depth] = i;
                dfs(i, depth + 1);
                
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
