// N과 M (5)
import java.util.Scanner;
import java.util.Arrays;

public class Baekjoon_15654 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static int[] output;

    private static void dfs(int depth) {
        if (depth == m) {
            for (int value : output) {
                System.out.print(value + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                output[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];
        output = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);


        dfs(0);
        sc.close();
    }
}
