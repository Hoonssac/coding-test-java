import java.util.Scanner;

public class Backjoon_2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int j = input - 1;
		
		for (int i = 1; i <= input; i++) {
			for (int k = 0; k < j; k++) {
				System.out.print(" ");
			}
			for (int m = 0; m < i; m++) {
				System.out.print("*");
			}
			System.out.println();
			j--;
		}
		
		sc.close();
	}
}
