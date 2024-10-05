import java.util.*;

public class Baekjoon_11722 {
    public static void main(String[] args) {
        /*
         * 10 30 10 20 20 10
         * 10 : 1 (10)
         * 30 : 1 (10 or 30)
         * 10 : 2 (30 10)
         * 20 : 2 (30 10 or 30 20)
         * 20 : 2 (30 10 or 30 20)
         * 10 : 3 (30 20 10)
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n]; // 수열 A
        int[] dp = new int[n];
        int result = 1;

        // 수열 A 입력
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);

        sc.close();
    }
}
