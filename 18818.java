import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static int[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		chk = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			Arrays.fill(chk[i], Integer.MAX_VALUE);
		}
		
		bfs();
	}
	private static void bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0, 4, 0));
		chk[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.x == N - 1 && p.y == N - 1) {
				System.out.println(p.cnt);
				return;
			}
			
			if(chk[p.x][p.y] < p.cnt) continue;
			chk[p.x][p.y] = p.cnt;
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == '#')
					continue;
				
				if(p.d == i) pq.offer(new Pair(nx, ny, p.d, p.cnt));
				else if(p.d != i) pq.offer(new Pair(nx, ny, i, p.cnt + 1));
			}
		}
		
		System.out.println(0);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, d, cnt;
	Pair(int x, int y, int d, int cnt) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cnt, o.cnt);
	}
}