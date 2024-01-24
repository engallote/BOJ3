import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, cnt, x, y;
	static boolean[][] chk;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		chk = new boolean[N][M];
		
		cnt = N * M;
		StringBuilder sb = new StringBuilder();
		int dx = 0, dy = 0;
		while(--Q >= 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 1) {
				dx = Integer.parseInt(st.nextToken());
				dy = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken()) - 1;
				y = Integer.parseInt(st.nextToken()) - 1;
				
				go(dx, dy);
			}
			else if(num == 2) {
				x = Integer.parseInt(st.nextToken()) - 1;
				y = Integer.parseInt(st.nextToken()) - 1;
				
				sb.append(chk[x][y] ? "1\n" : "0\n");
			}
			else {
				sb.append(cnt+"\n");
			}
		}
		
		System.out.println(sb);
	}
	private static void go(int dx, int dy) {
		if(chk[x][y]) return;
		chk[x][y] = true;
		cnt -= 1;
		
		while(true) {
			int nx = x + dx, ny = y + dy;
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) return;
			
			cnt -= 1;
			chk[nx][ny] = true;
			
			x = nx;
			y = ny;
		}
	}
}