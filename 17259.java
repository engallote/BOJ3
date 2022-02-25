import java.util.*;

public class Main {
	static int B, N, M;
	static int[][] map;
	static ArrayList<Pair> h;
	static int[] chk;
	static int[] dx = {-1, 0, 1}, dy = {0, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[B][B];
		h = new ArrayList<>();
		chk = new int[N];
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int time = sc.nextInt();
			h.add(new Pair(x, y, time));
		}
		
		solve();
	}
	private static void solve() {
		int res = 0, out = 0, cnt = 0;
		while(res + out < M) {
			if(cnt < M) {
				map[0][0] = 1;
				cnt += 1;
			}
			
			for(int i = 0; i < h.size(); i++) {
				if(chk[i] - 1 <= 0) {
					Pair p = h.get(i);
					int px = -1, py = 0;
					for(int d = 0; d < 3; d++) {
						int nx = p.x + dx[d], ny = p.y + dy[d];
						if(nx < 0 || ny < 0 || nx >= B || ny >= B || map[nx][ny] == 0) continue;
						px = nx;
						py = ny;
					}
					
					if(px != -1) {
						chk[i] = p.time;
						map[px][py] = 0;
						++res;
					}
				}
				else chk[i] -= 1;
			}
			if(map[B - 1][0] == 1) {
				out += 1;
			}
			rotate();
		}
		
		System.out.println(res);
	}
	private static void rotate() {
		for(int i = 0; i < B - 1; i++) map[B - 1][i] = map[B - 1][i + 1];
		for(int i = B - 1; i > 0; i--) map[i][B - 1] = map[i - 1][B - 1];
		for(int i = B - 1; i > 0; i--) map[0][i] = map[0][i - 1];
		map[0][0] = 0;
	}
}
class Pair{
	int x, y, time;
	Pair(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}