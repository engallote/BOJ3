import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][][] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	map = new int[5][5];
    	chk = new boolean[5][5][8];
    	
    	for(int i = 0; i < 5; i++)
    		for(int j = 0; j < 5; j++) map[i][j] = sc.nextInt();
    	
    	int sx = sc.nextInt();
    	int sy = sc.nextInt();
    	bfs(sx, sy);
	}
	private static void bfs(int sx, int sy) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(sx, sy, 0));
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.k == 6) {
					System.out.println(time);
					return;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || map[nx][ny] == -1) continue;
					
					if(p.k + 1 == map[nx][ny] && !chk[nx][ny][p.k + 1]) {
						chk[nx][ny][p.k + 1] = true;
						q.offer(new Pair(nx, ny, p.k + 1));
					}
					else {
						if(chk[nx][ny][p.k]) continue;
						chk[nx][ny][p.k] = true;
						q.offer(new Pair(nx, ny, p.k));
					}
				}
			}
			++time;
		}
		
		System.out.println(-1);
	}
}
class Pair {
	int x, y, k;
	Pair(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}
}