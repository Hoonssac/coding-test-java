import java.util.*;
import java.io.*;

public class Baekjoon_2164_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (true) {
            if (queue.size() == 1) {
                break;
            }
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
