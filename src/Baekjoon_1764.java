import java.util.*;

public class Baekjoon_1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> output = new ArrayList<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            map.put(input, null);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String input = sc.next();
            if (map.containsKey(input)) {
                count++;
                output.add(input);
            }
        }
        Collections.sort(output);
        System.out.println(count);
        for (String people : output) {
            System.out.println(people);
        }
        sc.close();
    }
}
