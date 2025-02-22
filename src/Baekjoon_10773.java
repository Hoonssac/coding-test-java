import java.io.*;
import java.util.*;

public class Baekjoon_10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                stack.pop();
            }
            else {
                stack.push(input);
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);

    }  
}
