// 미로 탐색
import java.util.*;

public class Baekjoon_2178 {
    static int[][] map;
    static boolean[][] visited;
    static int[][] step = {{-1,0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(map[n-1][m-1]); // 최단 경로의 길이 출력
        sc.close();
    }
    
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int a = now[0];
            int b = now[1];
            for (int i = 0; i < 4; i++) {
                int newA = a + step[i][0];
                int newB = b + step[i][1];
                if (newA >= 0 && newA < n && newB >= 0 && newB < m && map[newA][newB] != 0 && !visited[newA][newB]) {
                    queue.add(new int[]{newA, newB}); // x, y 순서로 추가
                    map[newA][newB] = map[a][b] + 1; // 경로 길이 업데이트
                    visited[newA][newB] = true;
                }
            }
        }
    }
}
