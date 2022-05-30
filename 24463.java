import java.util.*;

public class Main {
	static int N, M;
	static boolean flag;
	static char[][] map;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		chk = new boolean[N][M];
		flag = false;
		
		int sx = -1, sy = 0, ex = 0, ey = 0;
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '.' && (j == 0 || j == M - 1 || i == 0 || i == N - 1)) {
					if(sx == -1) {
						sx = i;
						sy = j;
					}
					else {
						ex = i;
						ey = j;
					}
				}
			}
		}
		
		dfs(sx, sy, ex, ey);
	}
	private static void dfs(int x, int y, int ex, int ey) {
		if(flag) return;
		if(x == ex && y == ey) {
			chk[ex][ey] = true;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == '.' && chk[i][j]) sb.append(".");
					else if(map[i][j] == '.' && !chk[i][j]) sb.append("@");
					else sb.append("+");
				}
				sb.append("\n");
			}
			
			flag = true;
			System.out.println(sb.toString());
			return;
		}
		
		chk[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || map[nx][ny] == '+')
				continue;
			
			dfs(nx, ny, ex, ey);
			if(flag) return;
		}
		chk[x][y] = false;
	}
}