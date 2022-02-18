import java.util.*;

public class Main {
	static int[][] map = new int[501][501], chk = new int[501][501];
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			makeMap(x1, y1, x2, y2, 1);
		}
		
		int M = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			makeMap(x1, y1, x2, y2, 2);
		}
		
		if(map[500][500] == 2) {
			System.out.println(-1);
			return;
		}
		
		for(int i = 0; i <= 500; i++) Arrays.fill(chk[i], Integer.MAX_VALUE);
		
		bfs();
	}
	private static void makeMap(int x1, int y1, int x2, int y2, int num) {
		if(x1 > x2) {
			int tmp = x1;
			x1 = x2;
			x2 = tmp;
		}
		if(y1 > y2) {
			int tmp = y1;
			y1 = y2;
			y2 = tmp;
		}
		for(int a = x1; a <= x2; a++)
			for(int b = y1; b <= y2; b++)
				map[a][b] = Math.max(map[a][b], num);
	}
	private static void bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0, 0));
		chk[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.x == 500 && p.y == 500) {
				System.out.println(p.hp);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx > 500 || ny > 500 || map[nx][ny] == 2) continue;
				if(map[nx][ny] == 0 && chk[nx][ny] > p.hp) {
					chk[nx][ny] = p.hp;
					pq.offer(new Pair(nx, ny, p.hp));
				}
				else if(map[nx][ny] == 1 && chk[nx][ny] > p.hp + 1) {
					chk[nx][ny] = p.hp + 1;
					pq.offer(new Pair(nx, ny, p.hp + 1));
				}
			}
		}
		
		System.out.println(-1);
	}
}
class Pair implements Comparable<Pair> {
	int x, y, hp;
	Pair(int x, int y, int hp) {
		this.x = x;
		this.y = y;
		this.hp = hp;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.hp, o.hp);
	}
}