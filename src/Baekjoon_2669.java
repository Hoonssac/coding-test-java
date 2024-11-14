// 직사각형 네개의 합집합의 면적 구하기
import java.util.Scanner;

public class Baekjoon_2669 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] map = new boolean[101][101];
        int a, b, c, d;
        int output = 0;

        for (int i = 0; i < 4; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();

            for (int j = a; j < c; j++) {
                for (int k = b; k < d; k++) {
                    map[j][k] = true;
                }
            }
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j]) {
                    output++;
                }
            }
        } 
        System.out.println(output);
        sc.close();
    }
}
