// 배열 돌리기 3
import java.util.Scanner;

public class Baekjoon_16935 {
    static int n;
    static int m;
    static int r;
    static int[][] map;
    static int[][] temp;

    // 1번 연산 : 상하 반전
    private static void command1() {
        temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[n-i-1][j];
            }
        }

        migration();
    }

    // 2번 연산 : 좌우 반전
    private static void command2() {
        temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[i][m-j-1];
            }
        }

        migration();
    }

    // 3번 연산 : 오른쪽으로 90도 회전
    private static void command3() {
        temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][n-i-1]= map[i][j];
            }
        }
        
        int tmp = n;
        n = m;
        m = tmp;
        map = new int[n][m];
        migration();
    }

    // 4번 연산 : 왼쪽으로 90도 회전
    private static void command4() {
        temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[m-j-1][i]= map[i][j];
            }
        }
        
        int tmp = n;
        n = m;
        m = tmp;
        map = new int[n][m];
        migration();
    }

    // 5번 연산 : 4개의 그룹으로 나눈 후 시계방향 회전
    private static void command5() {
        temp = new int[n][m];
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                temp[i][j + m/2] = map[i][j]; // 1 -> 2
                temp[i + n/2][j + m/2] = map[i][j + m/2]; // 2 -> 3
                temp[i + n/2][j] = map[i + n/2][j + m/2]; // 3 -> 4
                temp[i][j] = map[i + n/2][j]; // 4 -> 1
            }
        }

        migration();
    }

    private static void command6() {
        temp = new int[n][m];
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m/2; j++) {
                temp[i][j] = map[i][j + m/2]; // 2 -> 1
                temp[i][j + m/2] = map[i + n/2][j + m/2]; // 3 -> 2
                temp[i + n/2][j + m/2] = map[i + n/2][j]; // 4 -> 3
                temp[i + n/2][j] = map[i][j]; // 1 -> 4
            }
        }

        migration();
    }

    // 배열 이식
    private static void migration() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        int command = 0;
        map = new int[n][m];

        // 배열 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < r; i++) {
            command = sc.nextInt();
            switch (command) {
                case 1:
                    command1();
                    break;
                case 2:
                    command2();
                    break;
                case 3:
                    command3();
                    break;
                case 4:
                    command4();
                    break;
                case 5:
                    command5();
                    break;
                case 6:
                    command6();
                    break;
            }
        }


        // 배열 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();

    }
}
