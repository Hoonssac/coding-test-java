import java.util.*;

public class Baekjoon_1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 스위치 개수 입력
        int[] sw = new int[n + 1];

        // 스위치 입력
        for (int i = 1; i <= n; i++) {
            sw[i] = sc.nextInt();
        }

        int count = sc.nextInt(); // 학생 수 입력
        for (int i = 0; i < count; i++) {
            int gender = sc.nextInt(); // 성별 입력
            int pick = sc.nextInt(); // 받은 스위치 번호
            
            switch (gender) {
                case 1: // 남학생
                    for (int j = pick; j <= n; j++) {
                        if (j % pick == 0) {
                            if (sw[j] == 1) {
                                sw[j] = 0;
                            }
                            else {
                                sw[j] = 1;
                            }
                        }
                    }
                    break;

                case 2: // 여학생
                    int leftIndex = pick - 1;
                    int rightIndex = pick + 1;

                    if (leftIndex > 0 && rightIndex <= n && sw[leftIndex] == sw[rightIndex]) {
                        if (sw[pick] == 1) {
                            sw[pick] = 0;
                        }
                        else {
                            sw[pick] = 1;
                        }
                        while (leftIndex > 0 && rightIndex <= n && sw[leftIndex] == sw[rightIndex]) {
                            // 스위치 상태 변경
                            if (sw[leftIndex] == 1 && sw[rightIndex] == 1) {
                                sw[leftIndex] = 0;
                                sw[rightIndex] = 0;
                            }
                            else {
                                sw[leftIndex] = 1;
                                sw[rightIndex] = 1;
                            }
                            // 인덱스 변경
                            leftIndex--;
                            rightIndex++;
                        }
                    }
                    else {
                        if (sw[pick] == 1) {
                            sw[pick] = 0;
                        }
                        else {
                            sw[pick] = 1;
                        }
                    }


                    
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt > 0 && cnt % 20 == 0) {
                System.out.println();
            }
            System.out.print(sw[i] + " ");
            cnt++;

        }
        sc.close();
    }
}
