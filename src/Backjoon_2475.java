import java.util.Scanner;

public class Backjoon_2475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		int arr[] = new int[5];
		
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 5; i++) {
			result += Math.pow(arr[i], 2);
		}
		
		System.out.println(result % 10);
		sc.close();
	}
}
