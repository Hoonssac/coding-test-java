import java.util.Scanner;

public class Baekjoon_2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int test_case = sc.nextInt();
        for (int i = 0; i < test_case; i++) {
            StringBuilder now = new StringBuilder();
            int R = sc.nextInt();
            String input = sc.nextLine();
            for (int j = 1; j < input.length(); j++) {
                for (int k = 0; k < R; k++) {
                    now.append(input.charAt(j));
                }
            }
            output.append(now);
            output.append("\n");
        }
        System.out.println(output.toString());
        sc.close();
    }
}
