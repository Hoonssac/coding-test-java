import java.util.*;

public class Baekjoon_1012 {
	static int m, n;
	static int[][] map;
	static boolean[][] visited;
	static int[][] step = {{-1,0},{1,0},{0,-1},{0,1}};
	static Scanner sc;
	static int answer;
	static Queue<int[]> queue;
	
	public static int cabbage() {
		m = sc.nextInt(); // 행의 길이
		n = sc.nextInt(); // 열의 길이
		map = new int[m][n]; // 배추 지도 생성
		visited = new boolean[m][n]; // 방문 여부 저장
		int cabbageCount = sc.nextInt(); // 배추의 개수
		queue = new LinkedList<>(); // 큐 생성
		answer = 0;
		
		for (int i = 0; i < cabbageCount; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
		}		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j ++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j);
					answer++;
				}
			}
		}
		
		return answer;
		
	}
	
	public static void bfs(int a, int b) {
		queue.add(new int[] {a, b});
		visited[a][b] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int newA = current[0] + step[i][0];
				int newB = current[1] + step[i][1];
				
				if (newA >= 0 && newA < m && newB >= 0 && newB < n && map[newA][newB] == 1 && !visited[newA][newB]) {
					visited[newA][newB] = true;
					queue.add(new int[] {newA, newB});
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		sc = new Scanner(System.in);
		
		int testCount = sc.nextInt();
		
		for (int i = 0; i < testCount; i++) {
			arr.add(cabbage());
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
		
		sc.close();
	}
}
