import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10798 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] word = new char[5][15];
        int max = 0;

        for (int i = 0; i < word.length; i++) {
            String input = br.readLine();
            if (max < input.length()) {
                max = input.length();
            }

            for (int j = 0; j < input.length(); j++) {
                word[i][j] = input.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (word[j][i] == '\0') {
                    continue;
                }
                sb.append(word[j][i]);
            }
        }
        System.out.println(sb);
    }
}
