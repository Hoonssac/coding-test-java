import java.util.Scanner;

public class Backjoon_2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[9];
		int maxNum = 0;
		int index = 0;
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 9; i++) {
			if (arr[i] > maxNum) {
				maxNum = arr[i];
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if (arr[i] == maxNum) {
				index = i;
			}
		}
		
		System.out.println(maxNum);
		System.out.println(index + 1);
		
		sc.close();
	}
}
