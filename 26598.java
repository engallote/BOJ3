import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new char[N][M];
    	
    	for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
    	
    	boolean flag = true;
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if(map[i][j] != '.') {
    				flag = bfs(i, j);
    				if(!flag) {
    					System.out.println("BaboBabo");
    					return;
    				}
    			}
    	
    	System.out.println("dd");
	}
	private static boolean bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		char ch = map[x][y];
		map[x][y] = '.';
		
		int r = -1, c = -1, cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				r = Math.max(r, p.x);
				c = Math.max(c, p.y);
				++cnt;
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != ch) continue;
					
					map[nx][ny] = '.';
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		if(cnt != (r - x + 1) * (c - y + 1)) return false;
		else return true;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}