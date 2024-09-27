import java.util.*;

public class Baekjoon_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        sc.close();

        while (n > 0) {
            if (n < 3) {
                System.out.println(-1);
                return;
            }

            else if (n % 5 == 0) {
                answer += n / 5;
                System.out.println(answer);
                return;
            }
            n-=3;
            answer++;
            
        }



    }
}
