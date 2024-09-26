import java.util.*;

public class Baekjoon_3040 {
    public static int[] dwarves = new int[9];
    public static boolean[] selected = new boolean[9];

    public static void dfs(int count, int start, int sum) {
        if (count == 7) {
            if (sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if (selected[i]) {
                        System.out.println(dwarves[i]);
                    }
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            selected[i] = true; // 현재 난쟁이 선택
            dfs(count + 1, i + 1, sum + dwarves[i]); // 다음 난쟁이로 이동
            selected[i] = false; // 현재 난쟁이 선택 해제
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 난쟁이 입력
        for (int i = 0; i < 9; i++) {
            dwarves[i] = sc.nextInt();
        }
    
        // DFS를 통해 조합을 찾기
        dfs(0, 0, 0);

        sc.close();
    }
}
