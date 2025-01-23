import java.util.Scanner;

public class Baekjoon_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();
            people[i][0] = weight;
            people[i][1] = height;
        }

        for (int i = 0; i < N; i++) {
            int grade = 1;
            for (int j = 0; j < N; j++) {
                if (j != i && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    grade++;
                }
            }
            System.out.print(grade + " ");
        }
        sc.close();
    }
}
