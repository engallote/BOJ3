import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		while(--T >= 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] map = new char[N][M];
			boolean[][] chk = new boolean[N][M];
			
			for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
			
			if(map[0][0] == '*' || map[N - 1][M - 1] == '*') {
				System.out.println(-1);
				continue;
			}
			
			Queue<Pair> q = new LinkedList<>();
			q.offer(new Pair(0, 0));
			
			int res = 0;
			chk[0][0] = true;
			while(!q.isEmpty()) {
				int size = q.size();
				while(--size >= 0) {
					Pair p = q.poll();
					
					if(p.x == N - 1 && p.y == M - 1) {
						q.clear();
						break;
					}
					
					if(map[p.x][p.y] == '+') {
						for(int i = 0; i < 4; i++) {
							int nx = p.x + dx[i], ny = p.y + dy[i];
							
							if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || map[nx][ny] == '*') continue;
							
							chk[nx][ny] = true;
							q.offer(new Pair(nx, ny));
						}
					}
					else if(map[p.x][p.y] == '|') {
						for(int i = 0; i < 4; i++) {
							if(i % 2 != 0) continue;
							int nx = p.x + dx[i], ny = p.y + dy[i];
							
							if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || map[nx][ny] == '*') continue;
							
							chk[nx][ny] = true;
							q.offer(new Pair(nx, ny));
						}
					}
					else if(map[p.x][p.y] == '-') {
						for(int i = 0; i < 4; i++) {
							if(i % 2 == 0) continue;
							int nx = p.x + dx[i], ny = p.y + dy[i];
							
							if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || map[nx][ny] == '*') continue;
							
							chk[nx][ny] = true;
							q.offer(new Pair(nx, ny));
						}
					}
				}
				++res;
			}
			
			if(!chk[N-1][M-1]) System.out.println(-1);
			else System.out.println(res);
		}
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}