// 색종이
import java.util.Scanner;

public class Baekjoon_2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[100][100];
        int answer = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a-1; j < a + 9; j++) {
                for (int k = b-1; k < b + 9; k++) {
                    if (j < 100 && k < 100) {
                        map[j][k] = 1;
                    }
                }
            }
        }
        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                if (map[j][k] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
