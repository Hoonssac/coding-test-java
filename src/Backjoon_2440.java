import java.util.Scanner;

public class Backjoon_2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int j = input;
		
		for (int i = input; i > 0 ; i--) {
			for (int k = 0; k < j; k++) {
				System.out.print("*");
			}
			System.out.println();
			j--;
		}
		
		sc.close();
	}
}
