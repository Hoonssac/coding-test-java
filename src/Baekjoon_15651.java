import java.util.*;

public class Baekjoon_15651 {
    static int[] result;
    static int n;
    static int m;
    static StringBuilder output;

    static void dfs(int depth) {
        if (depth == m) {
            for (int i : result) {
                output.append(i + " ");
            }
            output.append("\n");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            result[depth] = i;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];
        output = new StringBuilder();
        dfs(0);
        System.out.println(output.toString());
        sc.close();
    }
}