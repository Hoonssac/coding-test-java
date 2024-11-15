// 줄 세우기
import java.util.Scanner;

public class Baekjoon_2605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[6];

        for (int i = 1; i <= n; i++) {
            int pick = sc.nextInt();
            arr[i] = i;
            int a = i;
            for (int j = 0; j < pick; j++) {
                // 앞으로 이동
                int temp = arr[a-1];
                arr[a-1] = arr[a];
                arr[a] = temp;
                a--;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
