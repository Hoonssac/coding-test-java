import java.util.*;
import java.io.*;

public class Baekjoon_25304 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());  
            total += (price * count);
        }

        if (X == total) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
    
}
