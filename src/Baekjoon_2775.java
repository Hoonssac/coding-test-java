import java.util.Scanner;

public class Baekjoon_2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] apt = new int[k+1][n+1];
            for (int j = 1; j <= n; j++) {
                apt[0][j] = j;
            }

            
            for (int j = 1; j <= k; j++) {
                for (int m = 1; m <= n; m++) {
                    int tmp = 0;
                    for (int l = 1; l <= m; l++) {
                        tmp += apt[j-1][l];
                    }
                    apt[j][m] = tmp;
                }
            }
            System.out.println(apt[k][n]);
        }
        sc.close();
    }
}
