import java.util.Scanner;

public class Backjoon_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt();

		int total = hour * 60 + min;
		int result = total - 45;

		if (result < 0) {
			result = 1440 + result;
		}
		hour = result / 60;
		min = result - hour * 60;
		
		System.out.print(hour + " " + min);
		
		sc.close();
	}
}
