import java.util.Scanner;
import java.util.Arrays;
 
public class Backjoon_2752 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[] numArr = new int[3];
        for (int i = 0; i < 3; i++) {
            numArr[i] = sc.nextInt();
        }
        
        Arrays.sort(numArr);
        
        for (int i = 0; i < 3; i++) {
            System.out.print(numArr[i] + " ");
            
        }
    }
}