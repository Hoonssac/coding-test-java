import java.util.Scanner;

public class Backjoon_1264 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "";
		String vowel = "AaEeIiOoUu";
		int count = 0;
		
		while (true)  {
			input = sc.nextLine();
			if (input.equals("#")) {
				break;
			}
			char chars[] = input.toCharArray();
			
			for (int i = 0; i < input.length(); i++) {
				if (vowel.contains(String.valueOf(chars[i]))) {
					count++;
				}
			}
			System.out.println(count);
			count = 0;
		}
		sc.close();
	}
}
