import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static char[][][] map;
	static int[][][] chk;
	static ArrayList<Pair> g;
	static int[] dx = {0, 1, 0, -1, 0}, dy = {1, 0, -1, 0, 0};
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;
		int ex = Integer.parseInt(st.nextToken()) - 1;
		int ey = Integer.parseInt(st.nextToken()) - 1;
		g = new ArrayList<>();
		map = new char[N][M][4];
		chk = new int[N][M][5];
		
		for(int i = 0; i < N; i++) {
			char[] ch = br.readLine().trim().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j][0] = map[i][j][1] = map[i][j][2] = map[i][j][3] = ch[j];
				if(ch[j] != '#' && ch[j] != '.') {
					g.add(new Pair(i, j, ch[j] - '0'));
					map[i][j][0] = map[i][j][1] = map[i][j][2] = map[i][j][3] = '#';
				}
				Arrays.fill(chk[i][j], 1000000000);
			}
		}
		
		ghost();
				
		bw.write(bfs(sx, sy, ex, ey));
		bw.flush();
	}
	private static String bfs(int sx, int sy, int ex, int ey) {
		int time = 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(sx, sy));
		
		while(!q.isEmpty()) {			
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x == ex && p.y == ey) {
					if(map[p.x][p.y][time % 4] == '.') return time+"";
				}
				
				//¿Ãµø
				for(int i = 0; i < 5; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny][(time + 1) % 4] != '.') continue;
					if(chk[nx][ny][(time + 1) % 4] <= time) continue;
										
					chk[nx][ny][(time + 1) % 4] = time;
					q.offer(new Pair(nx, ny));
				}
			}
			
			++time;
		}
		
		return "GG";
	}
	private static void ghost() {
		for(int i = 0; i < g.size(); i++) {
			for(int time = 0; time < 4; time++) {
				int x = g.get(i).x, y = g.get(i).y, d = g.get(i).d;
				int nd = (d + time) % 4;
				
				while(true) {
					x += dx[nd];
					y += dy[nd];
					
					if(x < 0 || y < 0 || x >= N || y >= M || map[x][y][time] == '#') break;
					map[x][y][time] = '@';
				}
			}
		}
	}
}
class Pair {
	int x, y, d;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}