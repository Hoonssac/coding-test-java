import java.util.Scanner;

public class Baekjoon_1388_1 {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int count;

    public static void dfs(int a, int b, int tile) {
        visited[a][b] = true;
        switch(tile) {
            case 1:
                if ((b+1) < M && map[a][b+1] == 1 && !visited[a][b+1]) {
                    dfs(a, b+1, tile);
                }
                break;
            case 2:
                if ((a+1) < N && map[a+1][b] == 2 && !visited[a+1][b]) {
                    dfs(a+1, b, tile);
                }
                break;
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        count = 0;

        // 바닥 입력
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '-') {
                    map[i][j] = 1; // - -> 1
                }
                else {
                    map[i][j] = 2; // | -> 2
                }
            }
        }

        // - 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j, map[i][j]);
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
