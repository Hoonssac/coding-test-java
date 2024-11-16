// 빙고
import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_2578 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[5][5];
        int[] num = new int[25];
        int count = 0;

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 사회자 번호 입력
        for (int i = 0; i < 25; i++) {
            num[i] = sc.nextInt();
        }
        sc.close();
        
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        ArrayList<Integer> cross = new ArrayList<>();
        for (int i = 0; i < 25; i++) {

            // 불린 번호 체크
            Loop:
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (num[i] == map[j][k]) {
                        map[j][k] = 0;
                        break Loop;
                    }
                }
            }

            // 빙고 여부 확인
            // 가로 확인
            for (int j = 0; j < 5; j++) {
                int rowSum = 0;
                for (int k = 0; k < 5; k++) {
                    rowSum += map[j][k];
                }
                if (rowSum == 0 && !row.contains(j)) {
                    count++;
                    row.add(j);
                }
            }
                
            // 세로 확인
            for (int j = 0; j < 5; j++) {
                int colSum = 0;
                for (int k = 0; k < 5; k++) {
                    colSum += map[k][j];
                }
                if (colSum == 0 && !col.contains(j)) {
                    count++;
                    col.add(j);
                }
            }

            // 대각선 확인
            int crossSum = 0;
            for (int k = 0; k < 5; k++) {
                crossSum += map[k][k];
            }
            if (crossSum == 0 && !cross.contains(0)) {
                count++;
                cross.add(0);
            }

            crossSum = 0;
            for (int k = 0; k < 5; k++) {
                crossSum += map[4-k][k];
            }
            if (crossSum == 0 && !cross.contains(1)) {
                count++;
                cross.add(1);
            }
        
            if (count >= 3) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
