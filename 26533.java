import java.util.*;

public class Main {
	static int N;
	static boolean flag = false;
	static char[][] map;
	static int[][] dp;
	static int[] dx = {1, 0}, dy = {0, 1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new char[N][N];
    	dp = new int[N][N];
    	
    	for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
    	
    	solve(0, 0);
    	System.out.println(flag ? "Yes" : "No");
	}
	private static void solve(int x, int y) {
		if(flag) return;
		if(x == N - 1 && y == N - 1) {
			flag = true;
			return;
		}
		if(dp[x][y] != 0) return;
		
		dp[x][y] = 1;
		
		for(int i = 0; i < 2; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 'x') continue;
			solve(nx, ny);
		}
	}
}