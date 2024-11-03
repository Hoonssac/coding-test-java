// 아기 상어
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_16236 {
    static int n;
    static int[][] map;
    static int nowSize;
    static int nowEat;
    static int nowTime;
    static int nowA;
    static int nowB;
    static int[][] step = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static boolean[][] visited;
    static Queue<int[]> queue;
    static Queue<int[]> canEat;
    static int[] destination;

    static void find() {
        visited = new boolean[n][n];
        queue = new LinkedList<>();
        canEat = new LinkedList<>();
        queue.add(new int[] {nowA, nowB, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] =true;
            
            for (int i = 0; i < 4; i++) {
                int newA = curr[0] + step[i][0];
                int newB = curr[1] + step[i][1];

                if (newA >= 0 && newA < n && newB >= 0 && newB < n && !visited[newA][newB] && map[newA][newB] <= nowSize) {
                    visited[newA][newB] = true;
                    queue.add(new int[] {newA, newB, curr[2] + 1});
                    if (map[newA][newB] != 0 && map[newA][newB] < nowSize) {
                        canEat.add(new int[] {newA, newB, curr[2] + 1});
                    }
                }
            }
        }
    }

    static void calDist() {
        destination = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        while (!canEat.isEmpty()) {
            int[] temp = canEat.poll();

            bfs(temp[0], temp[1]);
        }        
    }

    static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][n];
        visited[nowA][nowB] = true;
        queue.add(new int[] {nowA, nowB, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == a && curr[1] == b) {
                if ((curr[2] < destination[2]) || ((curr[2] == destination[2]) && ((a < destination[0]) || (a == destination[0] && b < destination[1])))) {
                    destination[0] = a;
                    destination[1] = b;
                    destination[2] = curr[2];
                }

                break;
            }

            for (int i = 0; i < 4; i++) {
                int newA = curr[0] + step[i][0];
                int newB = curr[1] + step[i][1];
    
                if (newA >= 0 && newA < n && newB >= 0 && newB < n && !visited[newA][newB] && map[newA][newB] <= nowSize) {
                    visited[newA][newB] = true;
                    queue.add(new int[] {newA, newB, curr[2] + 1});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nowSize = 2;
        nowEat = 0;
        nowTime = 0;
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    nowA = i;
                    nowB = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            find();
            if (canEat.isEmpty()) {
                break;
            }
            calDist();
            nowEat++;
            if (nowEat == nowSize) {
                nowSize++;
                nowEat = 0;
            }
            nowA = destination[0];
            nowB = destination[1];
            map[nowA][nowB] = 0;
            nowTime += destination[2];

        }
        System.out.println(nowTime);
        sc.close();
    }
}
