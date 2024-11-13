// 미로 탐색
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Baekjoon_2178_2 {
    static int[][] map;
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int n, m;

    // bfs
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int newA = temp[0] + step[i][0];
                int newB = temp[1] + step[i][1];

                if (newA >= 0 && newA < n && newB >= 0 && newB < m && !visited[newA][newB] && map[newA][newB] == 1) {
                    queue.add(new int[] {newA, newB});
                    map[newA][newB] = map[temp[0]][temp[1]] + 1;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];

        // 맵 입력
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(map[n-1][m-1]);
        sc.close();
    }
}
