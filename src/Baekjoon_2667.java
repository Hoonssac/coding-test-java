import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2667 {
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list;
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int count;

    public static void dfs(int a, int b) {
        visited[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int newA = a + step[i][0];
            int newB = b + step[i][1];

            if (newA >= 0 && newA < N && newB >= 0 && newB < N && !visited[newA][newB] && map[newA][newB] == 1) {
                count++;
                dfs(newA, newB);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int value : list) {
            System.out.println(value);
        }
        
    }
}