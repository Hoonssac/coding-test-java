import java.util.*;

public class Baekjoon_4963 {
    static int[][] map;
    static boolean[][] visited;
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // 상하좌우+대각선
    static int w;
    static int h;
    static int answer;
    static int count;
    static StringBuilder output;

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int newX = x + step[i][0];
            int newY = y + step[i][1];

            if (newX >= 0 && newX < h && newY >= 0 && newY < w && map[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(newX, newY);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();
        while (true) {
            // 변수 초기화
            w = sc.nextInt();
            h = sc.nextInt();
            answer = 0;
            count = 0;
            map = new int[h][w];
            visited = new boolean[h][w];
            // 종료 조건
            if (w == 0 && h == 0) {
                break;
            }

            // 지도 입력
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }

            dfs(0, 0);
            output.append(Integer.toString(answer) + "\n");
        }
        sc.close();
        System.out.println(output.toString());
    }
}
