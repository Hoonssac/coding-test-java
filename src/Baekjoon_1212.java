import java.util.Scanner;

public class Baekjoon_1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int now = input.charAt(i) - '0';

            int a, b, c = 0;
            a = now % 2;
            now = (now / 2);

            b = now % 2;
            now = now / 2;

            c = now % 2;
            now = now / 2;

            output.append(c);
            output.append(b);
            output.append(a);
        }

        int start = 0;
        while (start < output.length() && output.charAt(start) == '0') {
            start++;
        }

        // 모든 0이 제거된 경우
        if (start == output.length()) {
            System.out.println(0);
        } else {
            System.out.println(output.substring(start));
        }
        sc.close();
    }
}
