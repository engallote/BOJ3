import java.util.*;

public class Main {
	static int N;
	static char[][][] map;
	static boolean[][][] chk;
	static int[] dx = {1, 0, -1, 0, 0, 0}, dy = {0, 1, 0, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int sx = sc.nextInt() - 1;
		int sy = sc.nextInt() - 1;
		int sz = sc.nextInt() - 1;
		
		int ex = sc.nextInt() - 1;
		int ey = sc.nextInt() - 1;
		int ez = sc.nextInt() - 1;
		
		map = new char[N][N][N];
		chk = new boolean[N][N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				map[i][j] = sc.next().toCharArray();
		
		bfs(sx, sy, sz, ex, ey, ez);
	}
	private static void bfs(int sx, int sy, int sz, int ex, int ey, int ez) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(sx, sy, sz));
		chk[sz][sx][sy] = true;
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x == ex && p.y == ey && p.z == ez) {
					System.out.println(time);
					return;
				}
				
				for(int i = 0; i < 6; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i], nz = p.z + dz[i];
					
					if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= N || nz >= N) continue;
					if(map[nz][nx][ny] == '1' || chk[nz][nx][ny]) continue;
					
					chk[nz][nx][ny] = true;
					q.offer(new Pair(nx, ny, nz));
				}
			}
			time += 1;
		}
		
		System.out.println(-1);
	}
}
class Pair {
	int x, y, z;
	Pair(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}