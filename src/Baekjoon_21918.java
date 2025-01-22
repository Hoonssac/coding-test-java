import java.util.Scanner;

public class Baekjoon_21918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] bulbs = new int[N];
        
        // 전구 상태 입력
        for (int i = 0; i < N; i++) {
            bulbs[i] = sc.nextInt();
        }

        // 명령 입력 및 수행
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            switch (a) {
                case 1:
                    bulbs[b-1] = c;
                    break;
                case 2:
                    for (int j = b-1; j < c; j++) {
                        if (bulbs[j] == 0) {
                            bulbs[j] = 1;
                        }
                        else {
                            bulbs[j] = 0;
                        }
                    }
                    break;
                case 3:
                    for (int j = b-1; j < c; j++) {
                        bulbs[j] = 0;
                    }
                    break;
                case 4:
                    for (int j = b-1; j < c; j++) {
                        bulbs[j] = 1;
                    }
                    break;
            } 
            
        }

        // 전구 상태 출력
        for (int j = 0; j < N; j++) {
            System.out.print(bulbs[j] + " ");
        }
        
        sc.close();
    }
}
