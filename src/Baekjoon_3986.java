import java.io.*;
import java.util.*;

public class Baekjoon_3986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(input.charAt(j));
                }
                else {
                    if (stack.peek() == input.charAt(j)) {
                        stack.pop();
                    }
                    else {
                        stack.push(input.charAt(j));
                    }
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
