import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            
            switch(command) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "pop":
                    if (!stack.isEmpty()) {
                        System.out.println(stack.pop());
                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
                case "top":
                    if (!stack.isEmpty()) {
                        System.out.println(stack.peek());
                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;
            }
        }
        sc.close();
    }
}
