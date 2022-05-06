import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) map[i] = sc.next().toCharArray();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		
		bfs(x, y, k);
		
		for(int i = 0; i < R; i++) System.out.println(new String(map[i]));
	}
	private static void bfs(int x, int y, int k) {
		Queue<Pair> q = new LinkedList<>();
		char back = map[x][y];
		char c = (char)(k + '0');
		
		if(back == c) return;
		map[x][y] = c;
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != back) continue;
					
					map[nx][ny] = c;
					q.offer(new Pair(nx, ny));
				}
			}
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