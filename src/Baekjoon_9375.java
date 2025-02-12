import java.io.*;
import java.util.*;

public class Baekjoon_9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hash = new HashMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                hash.put(type, hash.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for(int val : hash.values())
                answer *= val + 1;
            bw.write(String.valueOf(answer - 1));
            bw.newLine();
        }
        bw.flush();
    }
}
