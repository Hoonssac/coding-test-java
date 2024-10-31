// 연구소
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Baekjoon_14502 {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int answer;

    private static void bfs() {

        // 맵 복사
        int[][] tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];

        // 바이러스 위치 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        // 바이러스 전파
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++) {
                int newA = now[0] + step[i][0];
                int newB = now[1] + step[i][1];

                if (newA >= 0 && newA < n && newB >= 0 && newB < m && !visited[newA][newB] && tempMap[newA][newB] == 0) {
                    tempMap[newA][newB] = 2;
                    queue.add(new int[] {newA, newB});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }
    
    private static void dfs(int wall) {
        if (wall == 3) {
            bfs(); // 바이러스 퍼뜨리기
            return;
        }

        // 안전 영역 개수 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        answer = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        // 맵 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 벽 세우기
        dfs(0);

        // 안전 영역 개수 춫력
        System.out.println(answer);

        sc.close();
    }
}
