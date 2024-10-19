// 전쟁 - 전투
import java.util.*;

public class Baekjoon_1303 {
    static char[][] map;
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] answer = {0, 0};
    static int count;

    private static void dfs (int a, int b, char who) {
        visited[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int newA = a + step[i][0];
            int newB = b + step[i][1];

            if (newA >= 0 && newA < n && newB >= 0 && newB < m && !visited[newA][newB] && map[newA][newB] == who) {
                count++;
                dfs(newA, newB, who);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    count = 1;
                    dfs(i, j, map[i][j]);
                    if (map[i][j] == 'W') {
                        answer[0] += count * count;
                    }
                    else {
                        answer[1] += count * count;
                    }
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
        sc.close();
    }
}
