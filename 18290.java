import java.util.*;

public class Main {
	static int N, M, K, max;
	static int[][] map;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		chk = new boolean[N][M];
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		solve(0, 0);
		
		System.out.println(max);
	}
	private static void solve(int idx, int sum) {
		if(idx == K) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(can(i, j) && !chk[i][j]) {
					chk[i][j] = true;
					solve(idx + 1, sum + map[i][j]);
					chk[i][j] = false;
				}
	}
	private static boolean can(int x, int y) {
		if(x - 1 >= 0 && chk[x - 1][y]) return false;
		if(x + 1 < N && chk[x + 1][y]) return false;
		if(y - 1 >= 0 && chk[x][y - 1]) return false;
		if(y + 1 < M && chk[x][y + 1]) return false;
		return true;
	}
}