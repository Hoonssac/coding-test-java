// 점프왕 쪨리 (Small)
import java.util.Scanner;

public class Baekjoon_16173 {
    static int[][] map;
    static boolean[][] visited;
    static int[][] jump = {{0, 1}, {1, 0}};
    static int n;
    static boolean win;

    private static void dfs(int a, int b) {
        visited[a][b] = true;
        if (map[a][b] == -1) {
            win = true;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int newA = a;
            int newB = b;
            for (int j = 0; j < map[a][b]; j++) {
                newA += jump[i][0];
                newB += jump[i][1];
            }
            if (newA >= 0 && newA < n && newB >= 0 && newB < n && !visited[newA][newB]) {
                dfs(newA, newB);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        // 맵 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
        if (win) {
            System.out.println("HaruHaru");
        }
        else {
            System.out.println("Hing");
        }
        sc.close();
    }
}
