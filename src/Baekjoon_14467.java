import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon_14467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int pos = sc.nextInt();
            
            if (map.containsKey(num)) {
                if (map.get(num) != pos) {
                    count++;
                    map.put(num, pos);
                }
            }
            else {
                map.put(num, pos);
            }
        }
        System.out.println(count);
        sc.close();
    }
}
