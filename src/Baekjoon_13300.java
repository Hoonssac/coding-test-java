// 방 배정
import java.util.Scanner;

public class Baekjoon_13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Your code here
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;
        int[] male = new int[7];
        int[] female = new int[7];
        for (int i = 0; i < n; i++) {
            int gender = sc.nextInt();
            int grade = sc.nextInt();
            
            if (gender == 1) {
                male[grade]++;
            }
            else {
                female[grade]++;
            }
        }

        for (int i = 1; i <= 6; i++) {
            answer = answer + (male[i] / k);
            if (male[i] % k > 0) {
                answer++;
            }

            answer = answer + (female[i] / k);
            if (female[i] % k > 0) {
                answer++;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}