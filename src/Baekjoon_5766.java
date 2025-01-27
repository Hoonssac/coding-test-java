import java.util.*;

public class Baekjoon_5766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int N = sc.nextInt();
            int M = sc.nextInt();
    
            if (N != 0 && M != 0) {
                Map<Integer, Integer> map = new HashMap<>();
                ArrayList<Integer> answer = new ArrayList<>();
                // 점수 입력
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int input = sc.nextInt();
                        if (map.containsKey(input)) {
                            map.put(input, map.get(input) + 1);
                        }
                        else {
                            map.put(input, 1);
                        }
                    }
                }
    
                // 1등 점수 계산
                int maxScore = 0;
                for (int player : map.keySet()) {
                    if (map.get(player) > maxScore) {
                        maxScore = map.get(player);
                    }
                }

                // 2등 점수 계산
                int secScore = 0;
                for (int player : map.keySet()) {
                    if (map.get(player) > secScore && map.get(player) != maxScore) {
                        secScore = map.get(player);
                    }
                }

                // 2등 선수 출력
                for (int player : map.keySet()) {
                    if (map.get(player) == secScore) {
                        answer.add(player);
                    }
                }
    
                Collections.sort(answer);
                for (int output : answer) {
                    System.out.print(output + " ");
                }
                System.out.println();
            }
            else {
                break;
            }
        }
        sc.close();
    }
}
