import java.util.*;

public class Baekjoon_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];

        arr[1] = sc.nextInt();

        for (int i = 2; i <= n; i++) {
            int temp = sc.nextInt();
            arr[i] = temp + arr[i-1];
        }

        for (int k = 0; k < m; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(arr[j] - arr[i - 1]);
        }
        sc.close();
    }
}
