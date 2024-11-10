// 가장 긴 증가하는 부분 수열
import java.util.Scanner;

public class Baekjoon_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(dp[j],max);
                }
                dp[i] = max + 1;
            }
        }

        max = 0;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        System.out.println(max);

        sc.close();
    }
}
