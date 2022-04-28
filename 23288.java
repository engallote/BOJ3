import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1}, dice = {2, 1, 5, 6, 4, 3};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		chk = new boolean[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		int d = 3;//첫 방향은 동쪽
		int x = 0, y = 0, res = 0;
		
		while(--K >= 0) {
			if(x + dx[d] < 0 || y + dy[d] < 0 || x + dx[d] >= N || y + dy[d] >= M)
				d = (d + 2) % 4;//이동할 수 없다면 후진
			
			x += dx[d];
			y += dy[d];
			
			if(d == 0) {
				int tmp = dice[3];
				dice[3] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[0];
				dice[0] = tmp;
			}
			else if(d == 1) {
				int tmp = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[3];
				dice[3] = tmp;
			}
			else if(d == 2) {
				int tmp = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = tmp;
			}
			else {
				int tmp = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[3];
				dice[3] = tmp;
			}
			
			int dn = dice[3], num = map[x][y];
			if(dn > num) {
				d += 1;
				d %= 4;
			}
			else if(dn < num) {
				d -= 1;
				if(d < 0) d = 3;
			}
			
			//점수 계산
			int cnt = find(x, y);
			res += num * cnt;
		}
		
		System.out.println(res);
	}
	private static int find(int x, int y) {
		for(int i = 0; i < N; i++) Arrays.fill(chk[i], false);
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt += size;
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != map[x][y] || chk[nx][ny])
						continue;
					
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		return cnt;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}