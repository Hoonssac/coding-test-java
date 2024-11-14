// 색종이
import java.util.Scanner;

public class Baekjoon_10163 {
    public static void main(String[] args) {
        int size = 1001;
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[size][size];
        int N = sc.nextInt();
        int number = 1;

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int aLength = sc.nextInt();
            int bLength = sc.nextInt();

            for (int j = a; j < a + aLength; j++) {
                for (int k = b; k < b + bLength; k++) {
                    map[j][k] = number;
                }
            }
            number++;
        }
        int[] arr = new int[number];

        for (int i = 1; i < number; i++) {
            for (int k = 0; k < size; k++) {
                for (int j = 0; j < size; j++) {
                    if (map[k][j] == i) {
                        arr[i] += 1;
                    }
                }
            }
        }

        for (int i = 1; i < number; i++) {
            System.out.println(arr[i]);
        }
        sc.close();
    }
}
