import java.util.*;

public class Baekjoon_9663 {
    static int[] map;
    static int answer = 0;

    public static void dfs(int start, int n) {
        if (start == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < start; j++) {
                if (map[j] == i || map[j] + (start-j) == i || map[j] - (start-j) == i) {
                    check = false;
                    break;
                }
            }
            if(check) {
                map[start] = i;
                dfs(start + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        map = new int[n];
        dfs(0, n);
        System.out.println(answer);

        sc.close();
    }
}
