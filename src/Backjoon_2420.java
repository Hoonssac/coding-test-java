import java.util.Scanner;
import java.math.BigInteger;

public class Backjoon_2420 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger result = a.subtract(b);
		
		System.out.println(result.abs());
		
		sc.close();
	}
}
