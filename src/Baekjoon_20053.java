import java.util.Scanner;

public class Baekjoon_20053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int max = -1000001;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                int input = sc.nextInt();
                if (input > max) {
                    max = input;
                }
                if (input < min) {
                    min = input;
                }
            }
            System.out.println(min + " " + max);
        }
        sc.close();
    }
}
