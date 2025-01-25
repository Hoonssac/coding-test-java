import java.util.Scanner;

public class Baekjoon_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result = a*b*c;
        String string = Integer.toString(result);
        int[] arr = new int[10];
        for (int i = 0; i < string.length(); i++) {
            arr[string.charAt(i) - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        sc.close();
    }
}
