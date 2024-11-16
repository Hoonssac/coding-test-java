// 경비원
import java.util.Scanner;

public class Baekjoon_2564 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;
        int police=0;
        int[] map = new int[k];

        for (int i = 0; i < k+1; i++) {
            int dir = sc.nextInt();
            int loc = sc.nextInt();
            int tmp = 0;
            switch (dir) {
                case 1:
                    tmp = loc;
                    break;
                case 2:
                    tmp = n + m + n - loc;
                    break;
                case 3:
                    tmp = n + m + n + m - loc;
                    break; 
                case 4:
                    tmp = n + loc;
                    break;
            }
            if (i < k) {
                map[i] = tmp;
            }
            else {
                police = tmp;
            }
        }

        for (int i = 0; i < k; i++) {
            int path1 = Math.abs(police-map[i]);
            int path2 = n + m + n + m - path1;
            answer += Math.min(path1, path2);
        }
        System.out.println(answer);
        sc.close();
    }
}