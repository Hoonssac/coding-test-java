import java.util.Scanner;

public class Baekjoon_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int count = 1;
        int nowNum = input;

        sc.close();

        while (true) {
            int tmp = (nowNum / 10) + (nowNum % 10);
            int newNum = (nowNum % 10) * 10 + (tmp % 10);
            if (newNum == input) {
                break;
            }
            else {
                nowNum = newNum;
                count++;
                continue;
            }
        }
        System.out.println(count);
    }
}
