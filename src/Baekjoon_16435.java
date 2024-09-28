import java.util.*;

public class Baekjoon_16435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fruitCount = sc.nextInt();
        int size = sc.nextInt();
        int[] fruits = new int[fruitCount];

        // 과일 입력
        for (int i = 0; i < fruitCount; i++) {
            fruits[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(fruits);

        for (int i = 0; i < fruitCount; i++) {
            if (fruits[i] <= size) {
                size++;
            }
            else {
                break;
            }
        }
        System.out.println(size);

        sc.close();

    }
}
