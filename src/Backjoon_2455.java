import java.util.Scanner;

public class Backjoon_2455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int in = 0;
		int out = 0;
		int count = 0;
		int peopleCount[] = new int[4];
		int result = 0;
		
		for (int i = 0; i < 4; i++) {
			out = sc.nextInt();
			in =sc.nextInt();
			count = count - out + in;
			peopleCount[i] = count;
		}
		
		for (int i = 1; i < 4; i++) {
			if (peopleCount[i] > result) {
				result = peopleCount[i];
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}
}
