import java.util.*;

public class Baekjoon_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] dp = new int[1000001]; // DP 배열 초기화
        dp[2] = 1; // 2를 1로 만드는 최소 횟수
        dp[3] = 1; // 3을 1로 만드는 최소 횟수
        for (int i = 4; i <= input; i++) {
            if (i %  6 == 0) {
                // 6으로 나누어진다면
                // 3으로 나누는 경우, 2로 나누는 경우 둘 다 확인
                dp[i] = Math.min(dp[i/3], Math.min(dp[i/2], dp[i-1])) + 1;
            }
            else if (i % 3 == 0) {
                // 3으로 나누어지는 경우
                dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
            }
            else if (i % 2 == 0) {
                // 2로 나누어지는 경우
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
            }
            else {
                // 3이나 2로 나누어지지 않는 경우
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(dp[input]);
        sc.close();
        
    }
}
