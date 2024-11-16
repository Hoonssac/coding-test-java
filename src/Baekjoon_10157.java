// 자리배정
import java.util.Scanner;

public class Baekjoon_10157 {
    static int[][] map;
    static int[][] step = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n;
    static int m;
    static int target;
    static boolean find;

    public static void dfs(int a, int b, int now, int dir) {
        if (now == target) {
            System.out.println((a+1) + " " + (b+1));
            find = true;
            return;
        }
        if (now == (n*m)) {
            return;
        }
        dir = dir % 4;
        map[a][b] = now;

        int newA = a + step[dir][0];
        int newB = b + step[dir][1];
        if (newA >= 0 && newA < n && newB >= 0 && newB < m && map[newA][newB] == 0) {
            dfs(newA, newB, now+1, dir);
        }
        else if (newA < 0 || newA >= n || newB < 0 ||  newB >= m || map[newA][newB] != 0) {
            dfs(a, b, now, dir+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        target = sc.nextInt();
        map = new int[n][m];

        dfs(0, 0, 1, 0);
        if (!find) {
            System.out.println("0");
        }
        sc.close();
    }
}
