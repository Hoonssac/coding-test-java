import java.io.*;
import java.util.*;

public class Baekjoon_11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                queue.add(input);
            }
            else {
                if (queue.isEmpty()) {
                    sb.append(0 + "\n");
                }
                else {
                    int out = queue.poll();
                    sb.append(out + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
