import java.util.Scanner;

public class Backjoon_2506 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		int totalScore = 0;
		int addScore = 1;
		int problem[] = new int[count + 1];
		
		for (int i = 0; i < count; i++) {
			problem[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= count; i++) {
			if (problem[i-1] == 1) {
				totalScore = totalScore + addScore;
				addScore++;
			}
			else {
				addScore = 1;
			}
		}
		System.out.println(totalScore);
		
		sc.close();
	}
}
