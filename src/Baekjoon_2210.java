// 숫자판 점프
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_2210 {
    static int[][] map;
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Stack<Integer> stack;
    static ArrayList<String> arr = new ArrayList<>();

    private static void check() {
        StringBuilder temp = new StringBuilder();
        for (int value : stack) {
            temp.append(value);
        }
        if (!arr.contains(temp.toString())) {
            arr.add(temp.toString());
        }
    }

    private static void dfs(int a, int b, int depth) {
        stack.add(map[a][b]);
        if (depth == 5) {
            // 중복 검사
            check();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newA = a + step[i][0];
            int newB = b + step[i][1];

            if (newA >= 0 && newA < 5 && newB >= 0 && newB < 5) {
                dfs(newA, newB, depth + 1);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                stack = new Stack<>();
                dfs(i, j, 0);
            }
        }
        System.out.println(arr.size());
        sc.close();
    }
}
