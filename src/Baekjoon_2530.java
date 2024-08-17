import java.util.Scanner;

public class Baekjoon_2530 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt();
		int sec = sc.nextInt();
		int time = hour * 3600 + min * 60 + sec;
		
		int runTime = sc.nextInt();
		time = time + runTime;
		
		System.out.print(time / 3600 % 24 + " ");
		System.out.print(time % 3600 / 60 + " ");
		System.out.print(time % 60);
		
		
		sc.close();
	}
}
