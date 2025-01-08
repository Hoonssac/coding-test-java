import java.util.Scanner;

public class Baekjoon_2588_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();

        System.out.println((b.charAt(2) - '0') * a);
        System.out.println((b.charAt(1) - '0') * a);
        System.out.println((b.charAt(0) - '0') * a);
        System.out.println(a * (Integer.parseInt(b)));
        sc.close();
    }
}
