// 봄버맨
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_16918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] map = new char[r][c];
        int n = sc.nextInt();
        int[][] bomb = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 맵 입력
        for (int i = 0; i < r; i++) {
            String input = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        // 1초 후일 경우
        if (c == 1) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

        // 짝수 초 후일 경우
        else if (n % 2 == 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print("O");
                }
                System.out.println();
            }
        }

        // 홀수 초 후일 경우
        else {
            for (int i = 0; i < n/2; i++) {

                // 폭탄 좌표 저장 및 모든 칸에 폭탄 설치
                Queue<int[]> queue = new LinkedList<>();
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (map[j][k] == 'O') {
                            // 폭탄 좌표 저장
                            queue.add(new int[] {j, k});
                        }
                        // 모든 칸에 폭탄 설치
                        map[j][k] = 'O';
                    }
                }

                while (!queue.isEmpty()) {
                    // 폭탄 좌표 추출
                    int[] temp = queue.poll();
                    int a = temp[0];
                    int b = temp[1];

                    // 폭발
                    map[a][b] = '.';
                    for (int j = 0; j < 4; j++) {
                        int newA = a + bomb[j][0];
                        int newB = b + bomb[j][1];

                        // 주변 4칸 폭발
                        if (newA >= 0 && newA < r && newB >= 0 && newB < c && map[newA][newB] == 'O') {
                            map[newA][newB] = '.';
                        }
                    }
                }
            }

            // 결과 출력
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    System.out.print(map[j][k]);
                }
                System.out.println();
            }
            // 1 3 5* 7 9* 11 13* 15 17*
        }
    }
}
