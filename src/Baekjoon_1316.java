import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon_1316 {
    static HashMap<Character, Integer> status = new HashMap<>();

    public static void reset() {
        status.put('a', 0);
        status.put('b', 0);
        status.put('c', 0);
        status.put('d', 0);
        status.put('e', 0);
        status.put('f', 0);
        status.put('g', 0);
        status.put('h', 0);
        status.put('i', 0);
        status.put('j', 0);
        status.put('k', 0);
        status.put('l', 0);
        status.put('m', 0);
        status.put('n', 0);
        status.put('o', 0);
        status.put('p', 0);
        status.put('q', 0);
        status.put('r', 0);
        status.put('s', 0);
        status.put('t', 0);
        status.put('u', 0);
        status.put('v', 0);
        status.put('w', 0);
        status.put('x', 0);
        status.put('y', 0);
        status.put('z', 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            reset();
            String input = sc.next();
            boolean check = false;
            if (input.length() == 1) {
                check = false;
            }
            else {
                status.put(input.charAt(0), 1);
                for (int j = 1; j < input.length(); j++) {
                    if (input.charAt(j-1) != input.charAt(j)) {
                        if (status.get(input.charAt(j)) == 1) {
                            check = true;
                            break;
                        }
                        else {
                            status.put(input.charAt(j), 1);
                        }
                    }
                    
                }
            }
            if (!check) {
                answer++;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
