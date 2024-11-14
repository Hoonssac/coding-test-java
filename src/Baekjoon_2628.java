// 종이자르기
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon_2628 {

    public static int getMatLen(int count, ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return count;
        }
        Collections.sort(arr);

        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            max = Math.max(max, arr.get(i) - arr.get(i - 1));
        }
        max = Math.max(max, count - arr.get(arr.size() - 1));
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = sc.nextInt();

        ArrayList<Integer> width = new ArrayList<>();
        ArrayList<Integer> height = new ArrayList<>();


        for (int i = 0; i < count; i++) {
            int direction = sc.nextInt();
            int line = sc.nextInt();
            if (direction == 0) {
                width.add(line);
            }
            else {
                height.add(line);
            }
        }
        int maxW = getMatLen(m, width);
        int maxH = getMatLen(n, height);
        System.out.println(maxW * maxH);
        sc.close();

    }
}
