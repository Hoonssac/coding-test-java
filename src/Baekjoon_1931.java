// 회의실 배정
import java.util.*;

public class Baekjoon_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] room = new int[n][2];
        int answer = 0;
        int endTime = 0;

        for (int i = 0; i < n; i++) {
            room[i][0] = sc.nextInt(); // 시작 시간
            room[i][1] = sc.nextInt(); // 종료 시간
        }
        
        // 종료 시간을 기준으로 오름차순 정렬
        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]); // 종료 시간 비교
            }
        });

        for (int i = 0; i < n; i++) {
            if (room[i][0] >= endTime) {
                endTime = room[i][1];
                answer++;
            }
        }
        System.out.println(answer);

        sc.close();
    }
}
