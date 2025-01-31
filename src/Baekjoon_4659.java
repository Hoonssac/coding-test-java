import java.util.Scanner;

public class Baekjoon_4659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.next();
            boolean acceptable = false;

            // 종료 조건
            if (input.equals("end")) {
                break;
            }

            // 첫 번째 조건
            for (int i = 0; i < input.length(); i++) {
                char now = input.charAt(i);
                if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
                    acceptable = true;
                }
            }

            // 두 번째 조건
            if (acceptable == true) {
                int vowels = 0;
                int consonants = 0;
                for (int i = 0; i < input.length(); i++) {
                    char now = input.charAt(i);
                    if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
                        consonants = 0;
                        vowels++;
                    }
                    else {
                        vowels = 0;
                        consonants++;
                    }

                    if (vowels == 3 || consonants == 3) {
                        acceptable = false;
                        break;
                    }
                }
            }

            // 세 번째 조건
            if (acceptable == true && input.length() > 1) {
                for (int i = 1; i < input.length(); i++) {
                    char now = input.charAt(i);
                    char before = input.charAt(i-1);
                    if (now == before && now != 'e' && now != 'o') {
                        acceptable = false;
                    }
                }
            }
            
            // 결과 출력
            if (acceptable) {
                System.out.println("<" + input + "> is acceptable.");
            }
            else {
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
        sc.close();
    }
}
