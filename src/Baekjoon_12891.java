import java.util.*;

public class Baekjoon_12891 {
    static int answer = 0;
    static int[] compare;
    static char[] arr;
    static int s;
    static int p;
    static int[] dna;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        p = sc.nextInt();
        arr = new char[s]; // 입력 문자열
        compare = new int[4]; // 비교 문자열
        dna = new int[4]; // A, C, G, T 개수

        // 문자열 입력
        String input = sc.next();
        for (int i = 0; i < s; i++) {
            arr[i] = input.charAt(i);
        }

        // A, C, G, T 개수 입력
        for (int i = 0; i < 4; i++) {
            dna[i] = sc.nextInt();
        }

        // 첫 번째 조합 검사
        for (int i = 0; i < p; i++) {
            char temp = arr[i];
            boolean isDna = true;
            switch (temp) {
                case 'A':
                    compare[0] += 1;
                    break;
                case 'C':
                    compare[1] += 1;
                    break;
                case 'G':
                    compare[2] += 1;
                    break;
                case 'T':
                    compare[3] += 1;
                    break; 
            }
        }
        boolean isDna = true;
        for (int j = 0; j < 4; j++) {
            if (dna[j] > compare[j]) {
                isDna = false;
                break;
            }
        }
        if (isDna) {
            answer++;
        }

        for (int startIndex = 1; startIndex <= s - p; startIndex++) {
            isDna = true;
            char leftTemp = arr[startIndex - 1];
            char rightTemp = arr[startIndex + p - 1];
            switch (leftTemp) {
                case 'A':
                    if (compare[0] > 0)
                        compare[0]--;
                    break;
                case 'C':
                    if (compare[1] > 0)
                        compare[1]--;
                    break;
                case 'G':
                    if (compare[2] > 0)
                        compare[2]--;
                    break;
                case 'T':
                    if (compare[3] > 0)
                        compare[3]--;
                    break;
            }
            switch (rightTemp) {
                case 'A':
                    compare[0]++;
                    break;
                case 'C':
                    compare[1]++;
                    break;
                case 'G':
                    compare[2]++;
                    break;
                case 'T':
                    compare[3]++;
                    break;
            }
            for (int j = 0; j < 4; j++) {
                if (dna[j] > compare[j]) {
                    isDna = false;
                    break;
                }
            }
            if (isDna) {
                answer++;
            }
        }
        
        System.out.println(answer);
        sc.close();
    }
}