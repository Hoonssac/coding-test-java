import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_20920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> words = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() >= M) {
                words.put(input, words.getOrDefault(input, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>(words.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 자주 등장하는 단어 순서대로 정렬
                if (Integer.compare(words.get(o1), words.get(o2)) != 0) {
                    // o1의 등장 횟수가 더 크면 양수를 반환
                    // o2의 등장 횟수가 더 크면 음수를 반환
                    // 두 등장 횟수가 같으면 0을 반환
                    // != : 두 단어의 등장 횟수가 다른 경우에만 실행
                    return Integer.compare(words.get(o2), words.get(o1));
                }
                
                // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }

                // 등장 횟수와 길이가 같으면 사전 순으로 정렬
                return o1.compareTo(o2);
            }
        });

        StringBuilder output = new StringBuilder();
        for (String str : list) {
            output.append(str + "\n");
        }
        System.out.println(output);
    }
}
