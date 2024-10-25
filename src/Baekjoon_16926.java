// 배열 돌리기 1
import java.util.Scanner;

public class Baekjoon_16926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < Math.min(n, m) / 2; j++) {
                // j번째 껍데기
                int temp = map[j][j];
                for (int k = j + 1; k < m - j; k++) {
                    map[j][k-1] = map[j][k];
                }

                for (int k = j + 1; k < n - j; k++) {
                    map[k-1][m-j-1] = map[k][m-j-1];
                }

                for (int k = m-2-j; k >= j; k--) {
                    map[n-1-j][k+1] = map[n-1-j][k];
                }

                for (int k = n-j-2; k >= j; k--) {
                    map[k+1][j] = map[k][j]; 
                }
                map[j+1][j] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                output.append(map[i][j] + " ");
            }
            output.append("\n");
        }
        System.out.println(output.toString());
        sc.close();

    }
}
