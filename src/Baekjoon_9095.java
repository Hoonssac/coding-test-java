import java.util.*;

public class Baekjoon_9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;
        for (int j = 5; j < 11; j++) {
            dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
        }

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
        sc.close();
    }
}

