import java.util.*;

public class Baekjoon_28278 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            int order = sc.nextInt();

            switch(order) {
                case 1:
                    int x = sc.nextInt();
                    stack.push(x);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        output.append(stack.pop() + "\n");
                    }
                    else {
                        output.append(-1 + "\n");
                    }
                    break;
                case 3:
                    output.append(stack.size() + "\n");
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        output.append(1 + "\n");
                    }
                    else {
                        output.append(0 + "\n");
                    }
                    break;
                case 5:
                    if (!stack.isEmpty()) {
                        output.append(stack.peek() + "\n");
                    }
                    else {
                        output.append(-1 + "\n");
                    }
                    break;
            }
        }
        System.out.println(output.toString());
        
        sc.close();
    }
}
