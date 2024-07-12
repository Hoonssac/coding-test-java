import java.util.Scanner;

public class Backjoon_2083 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int age = 0;
		int weight = 0;
		String name;
		
		while (true) {
			name = sc.next();
			age = sc.nextInt();
			weight = sc.nextInt();
			
			if (name.equals("#") && age == 0 && weight == 0) {
				break;
			}
			else if (age > 17 || weight >= 80) {
				System.out.println(name + " Senior");
			}
			else {
				System.out.println(name + " Junior");
			}			
		}
		
		sc.close();
	}
}
