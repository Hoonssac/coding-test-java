import java.util.Scanner;

public class Baekjoon_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                count++;
            }
        }
        if (input.charAt(0) == ' ') {
            count--;
        }
        if (input.charAt(input.length()-1) == ' ') {
            count--;
        }
        System.out.println(count + 1);
        sc.close();
    }
}