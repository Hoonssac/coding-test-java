import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A', 0);
        hashMap.put('B', 0);
        hashMap.put('C', 0);
        hashMap.put('D', 0);
        hashMap.put('E', 0);
        hashMap.put('F', 0);
        hashMap.put('G', 0);
        hashMap.put('H', 0);
        hashMap.put('I', 0);
        hashMap.put('J', 0);
        hashMap.put('K', 0);
        hashMap.put('L', 0);
        hashMap.put('M', 0);
        hashMap.put('N', 0);
        hashMap.put('O', 0);
        hashMap.put('P', 0);
        hashMap.put('Q', 0);
        hashMap.put('R', 0);
        hashMap.put('S', 0);
        hashMap.put('T', 0);
        hashMap.put('U', 0);
        hashMap.put('V', 0);
        hashMap.put('W', 0);
        hashMap.put('X', 0);
        hashMap.put('Y', 0);
        hashMap.put('Z', 0);

        String input = sc.next();
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            hashMap.put(now, hashMap.get(now) + 1);
        }

        input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int max = 0;
        int count = 0;
        char answer = ' ';
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (hashMap.get(now) > max) {
                max = hashMap.get(now);
                answer = now;
            }
        }

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (hashMap.get(now) == max) {
                count++;
            }
        }

        if (count > 1) {
            System.out.println("?");
        }
        else {
            System.out.println(answer);
        }

        sc.close();
    }
}

