// 창고 다각형
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_2304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxH = 0;
        int maxL = 0;
        int end = 0;
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 기둥 입력
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int h = sc.nextInt();
            if (maxH < h) {
                maxH = h;
                maxL = l;
            }
            end = Math.max(end, l);
            hashMap.put(l, h);
        }

        // 가장 큰 기둥 기준으로 왼쪽 면적
        stack.add(0);
        for (int i = 0; i <= maxL; i++) {
            if (hashMap.containsKey(i) && hashMap.get(i) >= stack.peek()) {
                stack.add(hashMap.get(i));
            }
            answer += stack.peek();
        }

        // 가장 큰 기둥 기준으로 오른쪽 면적
        stack = new Stack<>();
        stack.add(0);
        for (int i = end; i > maxL; i--) {
            if (hashMap.containsKey(i) && hashMap.get(i) >= stack.peek()) {
                stack.add(hashMap.get(i));
            }
            answer += stack.peek();
        }
        System.out.println(answer);
        sc.close();
    }
}
