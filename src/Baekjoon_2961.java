// 도영이가 만든 맛있는 음식
import java.util.*;

public class Baekjoon_2961 {
    static int n;
    static int[][] ingredient;
    static int answer = Integer.MAX_VALUE;

    static void dfs(int depth, int sour, int bitter, int count) {
        if (depth == n) {
            if (count != 0) {
                if (Math.abs(sour - bitter) < answer) {
                    answer = Math.abs(sour - bitter);
                }
            }
            return;
        }
        // 넣o
        dfs(depth + 1, sour * ingredient[depth][0], bitter + ingredient[depth][1], count + 1);
        // 넣x
        dfs(depth + 1, sour, bitter, count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ingredient = new int[n][2];

        // 재료 입력
        for (int i = 0; i < n; i++) {
            ingredient[i][0] = sc.nextInt();
            ingredient[i][1] = sc.nextInt();
        }

        dfs(0, 1, 0, 0);
        System.out.println(answer);
        sc.close();
    }
}
