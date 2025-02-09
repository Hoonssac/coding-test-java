import java.io.*;
import java.util.*;

public class Baekjoon_20291 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> file = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] tmp = input.split("\\.");
            file.putIfAbsent(tmp[1], 0);
            file.put(tmp[1], file.get(tmp[1]) + 1);
        }

        List<String> keys = new ArrayList<>(file.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String key : keys) {
            System.out.println(key + " " + file.get(key));
        }
    }
}
