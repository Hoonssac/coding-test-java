import java.util.*;

public class Baekjoon_11725 {
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static boolean[] visited; // 방문 여부
    static int[] parents; // 부모 노드 저장

    static void dfs(int node) {
        visited[node] = true; // 방문 표시
        
        // v : node의 자식 노드들
        for (int v : edges.get(node)) {
            if (!visited[v]) {
                dfs(v);
                parents[v] = node;
            }
        }
    }
    
    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            for (int v : edges.get(temp)) {
                if (!visited[v]) {
                    queue.add(v);
                    parents[v] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        visited = new boolean[size + 1];
        parents = new int[size + 1];

        // 노드 생성
        for (int i = 0; i <= size; i++) {
            edges.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < size - 1; i++) {
            String[] input = sc.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        // 1번 노드부터 탐색 시작
        bfs(1);

        for (int i = 2; i <= size; i++) {
            System.out.println(parents[i]);
        }

        sc.close();
    }
}
