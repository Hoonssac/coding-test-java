import java.util.Scanner;

public class Baekjoon_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String input = sc.next();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < abc.length(); i++) {
            int tmp = abc.charAt(i);
            int position = -1;
            for (int j = 0; j < input.length(); j++) {
                if (tmp == input.charAt(j)) {
                    position = j;
                    break;
                }
                else {
                    continue;
                }
            }

            if (position == -1) {
                output.append(-1 + " ");
            }
            else {
                output.append(position + " ");
            }
        }
        System.out.println(output.toString());
        sc.close();
        
    }
}
