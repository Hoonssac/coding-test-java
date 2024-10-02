import java.util.*;

public class Baekjoon_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n : 1 => 1가지
        // n : 2 => 2가지
        // n : 3 => 3가지
        // n : 4 => 5가지
        // n : 5 => 8가지
        // n = n-2가지 + n-1가지
        int n = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
