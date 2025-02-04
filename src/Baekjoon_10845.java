import java.util.*;

public class Baekjoon_10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<Integer>();
        int N = sc.nextInt();
        int last = 0;

        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch(command) {
                case"push":
                    int input = sc.nextInt();
                    last = input;
                    queue.add(input);
                    break;
                case"pop":
                    if (!queue.isEmpty()) {
                        int output = queue.poll();
                        System.out.println(output);
                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
                case"size":
                    System.out.println(queue.size());
                    break;
                case"empty":
                    if (!queue.isEmpty()) {
                        System.out.println(0);
                    }
                    else {
                        System.out.println(1);
                    }
                    break;
                case"front":
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peek());
                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
                case"back":
                    if (!queue.isEmpty()) {
                        System.out.println(last);
                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
                    
            }
        }
        sc.close();
    }
}