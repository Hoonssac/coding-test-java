// 미세먼지 안녕!
import java.util.Scanner;

public class Baekjoon_17144 {
    static int r, c, t;
    static int[][] map;
    static int[][] newMap;
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int filter;
    static int answer;

    private static void spread() {
        newMap = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) {
                    newMap[i][j] = -1;
                }
                if (map[i][j] != 0 && map[i][j] != -1) {
                    int dust = map[i][j] / 5;
                    newMap[i][j] += map[i][j] - (dust * 5);
                    newMap[i][j] += dust;

                    for (int k = 0; k < 4; k++) {
                        int newA = i + step[k][0];
                        int newB = j + step[k][1];
                        
                        if (newA >= 0 && newA < r && newB >= 0 && newB < c && map[newA][newB] != -1) {
                            newMap[newA][newB] += dust;
                        }
                        else {
                            newMap[i][j] += dust;
                        }
                    }
                }
            }
        }
    }

    private static void cycle() {
        // 위쪽 공기청정
        filter--;
        for (int i = filter - 1; i > 0; i--) {
            newMap[i][0] = newMap[i-1][0];
        }
        for (int i = 0; i < c-1; i++) {
            newMap[0][i] = newMap[0][i+1];
        }
        for (int i = 0; i < filter; i++) {
            newMap[i][c-1] = newMap[i+1][c-1];
        }
        for (int i = c-1; i > 1; i--) {
            newMap[filter][i] = newMap[filter][i-1];
        }
        newMap[filter][1] = 0;
        filter++;

        // 아래쪽 공기청정
        for (int i = filter + 1; i < r - 1; i++) {
            newMap[i][0] = newMap[i+1][0];
        }
        for (int i = 0; i < c-1; i++) {
            newMap[r-1][i] = newMap[r-1][i+1];
        }
        for (int i = r-1; i > filter; i--) {
            newMap[i][c-1] = newMap[i-1][c-1];
        }
        for (int i = c-1; i > 1; i--) {
            newMap[filter][i] = newMap[filter][i-1];
        }
        newMap[filter][1] = 0;

        // 맵 업데이트
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = newMap[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        map = new int[r][c];
        newMap = new int[r][c];
        answer = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    newMap[i][j] = -1;
                    filter = i;
                }
            }
        }

        for (int i = 0; i < t; i++) { 
            spread(); // 미세먼지 확산
            cycle(); // 공기 순환
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                answer += map[i][j];
            }
        }

        System.out.println(answer + 2);
        sc.close();
    }
}
