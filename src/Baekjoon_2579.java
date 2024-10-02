import java.util.*;

public class Baekjoon_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 해당 칸의 최고 점수 : 해당 칸까지 올 수 있는 경우 중 큰 값 + 해당 칸의 점수
        // score[n] = Math.max(score[n-3] + stair[n-1], score[n-2]) + stair[n]
        int n = sc.nextInt();
        int[] stair = new int[301]; // 계단 정보
        int[] score = new int[301]; // 최대 점수
        for (int i = 1; i <= n; i++) {
            stair[i] = sc.nextInt();
        }

        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        score[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int i = 4; i <= n; i++) {
            score[i] = Math.max(score[i-3] + stair[i-1], score[i-2]) + stair[i];
        }
        System.out.println(score[n]);
        sc.close();
    }
}
