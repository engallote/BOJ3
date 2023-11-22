import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr, chk;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		chk = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			if(start(i)) {
				q.offer(i);
			}
			clear();
		}
		
		System.out.println(q.size());
		while(!q.isEmpty()) System.out.print((q.poll() + 1) + " ");
	}
	private static void clear() {
		for(int i = 0; i < N; i++) Arrays.fill(chk[i], 0);
	}
	private static boolean start(int idx) {
		int x = idx, y = 0, d = 0;
		
		while(true) {
			chk[x][y] += 1;
			int num = arr[x][y];
			
			if(x + dx[d] * num < 0 || y + dy[d] * num < 0 || x + dx[d] * num >= N || y + dy[d] * num >= M) return false;
			if(chk[x + dx[d] * num][y + dy[d] * num] >= 3) break;
			
			x += dx[d] * num;
			y += dy[d] * num;
			d += 1;
			d %= 4;
		}
		
		return true;
	}
}