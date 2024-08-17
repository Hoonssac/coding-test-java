import java.util.Scanner;

public class Baekjoon_1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int result = Math.min(x, y);
		result = Math.min(result,  w - x);
		result = Math.min(result, h - y);
		
		System.out.println(result);
		
		sc.close();
	}
}
