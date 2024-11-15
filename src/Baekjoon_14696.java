// 딱지놀이
import java.util.Scanner;

public class Baekjoon_14696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder output = new StringBuilder();
        int[] A;
        int[] B;

        for (int i = 0; i < N; i++) {
            // 딱지 정보 입력
            A = new int[5];
            B = new int[5];
            int a = sc.nextInt();
            for (int j = 0; j < a; j++) {
                int shape = sc.nextInt();
                A[shape]++;
            }
            int b = sc.nextInt();
            for (int j = 0; j < b; j++) {
                int shape = sc.nextInt();
                B[shape]++;
            }

            // 대결
            for (int j = 4; j >= 0; j--) {
                if (A[j] > B[j]) {
                    output.append("A\n");
                    break;
                }
                else if (A[j] < B[j]) {
                    output.append("B\n");
                    break;
                }
                else if (j == 0) {
                    output.append("D\n");
                    break;
                }
            }

        }
        // 결과 출력
        System.out.println(output.toString());
        sc.close();
    }
}
