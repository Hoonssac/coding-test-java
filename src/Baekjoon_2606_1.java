import java.util.Scanner;

public class Baekjoon_2606_1 {
    static int[][] map;
    static boolean[] visited;
    static int C,N;
    static int count = 0;

    public static void dfs(int computer) {
        visited[computer] = true;

        for (int i = 1; i <= C; i++) {
            if (map[i][computer] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        N = sc.nextInt();
        map = new int[C+1][C+1];
        visited = new boolean[C+1];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(1);
        System.out.println(count);
        sc.close();
    }
}
