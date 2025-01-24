import java.util.Scanner;

public class Baekjoon_10709 {
    static char[][] map;
    static int[][] output;
    static int H, W;
    static int time;

    public static void move(int a, int b) {
        if (b+1 < W) {
            for (int i = b+1; i < W; i++) {
                time++;
                if (map[a][i] == '.') {
                    output[a][i] = time;
                }
                else {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 날씨 입력
        H = sc.nextInt();
        W = sc.nextInt();
        map = new char[H][W];
        output = new int[H][W];
        for (int i = 0; i < H; i++) {
            String input = sc.next();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);
                if (input.charAt(j) == 'c') {
                    output[i][j] = 0;
                }
                else {
                    output[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'c') {
                    // 구름 이동
                    time = 0;
                    move(i, j);

                }
            }
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}