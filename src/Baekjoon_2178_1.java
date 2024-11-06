// 미로 탐색
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2178_1 {
    static int[][] map;
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int n;
    static int m;

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            if (temp[0] == (n-1) && temp[1] == (m-1)) {
                break;
            }
            
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

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m ;j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(map[n-1][m-1]);
        sc.close();
    }
}
