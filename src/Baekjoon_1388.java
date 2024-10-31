// 바닥 장식
import java.util.Scanner;

public class Baekjoon_1388 {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int answer;

    private static void dfs(int a, int b) {
        visited[a][b] = true;

        if (map[a][b] == '-') {
            if ((b-1) >= 0 && !visited[a][b-1] && map[a][b-1] == '-') {
                dfs(a, b-1);
            }

            if ((b+1) < m && !visited[a][b+1] && map[a][b+1] == '-') {
                dfs(a, b+1);
            }
        }
        else if (map[a][b] == '|') {
            if ((a-1) >= 0 && !visited[a-1][b] && map[a-1][b] == '|') {
                dfs(a-1, b);
            }

            if ((a+1) < n && !visited[a+1][b] && map[a+1][b] == '|') {
                dfs(a+1, b);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        visited = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
        sc.close();
    }
}
