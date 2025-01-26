import java.util.*;

public class Baekjoon_9017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] answer = new int[T];
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N+1];
            Map<Integer, Integer> count = new HashMap<>(); // 팀별 인원 수
            Map<Integer, Integer> fifth = new HashMap<>(); // 다섯 번째 주자 점수 인덱스
            Map<Integer, Integer> total = new HashMap<>(); // 팀별 최종 점수

            // 점수표 입력
            for (int j = 1; j <= N; j++) {
                int input = sc.nextInt();
                arr[j] = input;
                if (count.containsKey(input)) {
                    count.put(input, count.get(input) + 1);
                    if (count.get(input) == 5) {
                        fifth.put(input, j);
                    }
                }
                else {
                    count.put(input, 1);
                }
            }

            // 점수 계산
            int nowScore = 0;
            for (int j = 1; j <= N; j++) {
                if (count.get(arr[j]) == 6) {
                    nowScore++;
                    if (total.containsKey(arr[j]) && j < fifth.get(arr[j])) {
                        total.put(arr[j], total.get(arr[j]) + nowScore);
                    }
                    else if (!total.containsKey(arr[j]) && j < fifth.get(arr[j])){
                        total.put(arr[j], nowScore);
                    }
                }
            }

            // 우승자 선정
            int max = Integer.MAX_VALUE;
            int winner = 0;
            for (int team : total.keySet()) {
                if (total.get(team) < max) {
                    winner = team;
                    max = total.get(team);
                }
            }

            // 동점자 계산
            for (int team : total.keySet()) {
                if (team != winner && total.get(team) == max && fifth.get(winner) > fifth.get(team)) {
                    winner = team;
                }
            }
            
            answer[i] = winner;

        }
        for (int output : answer) {
            System.out.println(output);
        }
        sc.close();
    }
}
