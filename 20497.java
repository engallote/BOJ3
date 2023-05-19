import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static ArrayList<Pair> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		chk = new boolean[N][N];
		ArrayList<Pair> aly = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < N; j++)
				if(map[i][j] == '.') aly.add(new Pair(i, j));
		}
		
		int res = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(map[i][j] == '.') {
					map[i][j] = '@';
					
					if(i - 1 >= 0 && map[i - 1][j] == '.') {
						bfs(i - 1, j);
					}
					else if(i + 1 < N && map[i + 1][j] == '.') {
						bfs(i + 1, j);
					}
					else if(j - 1 >= 0 && map[i][j - 1] == '.') {
						bfs(i, j - 1);
					}
					else if(j + 1 < N && map[i][j + 1] == '.') {
						bfs(i, j + 1);	
					}
					
					if(check(i, j)) ++res; 
					
					map[i][j] = '.';
				}
		
		System.out.println(res);
	}
	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				System.out.print((chk[i][j] ? 1 : 0) + " ");
			System.out.println();
		}
		System.out.println("=============");
	}
	private static boolean check(int x, int y) {
		int dot = 0, ch = 0;
		if(x - 1 >= 0 && map[x - 1][y] == '.') {
			++dot;
			if(chk[x - 1][y]) ++ch;
		}
		if(x + 1 < N && map[x + 1][y] == '.') {
			++dot;
			if(chk[x + 1][y]) ++ch;
		}
		if(y - 1 >= 0 && map[x][y - 1] == '.') {
			++dot;
			if(chk[x][y - 1]) ++ch;
		}
		if(y + 1 < N && map[x][y + 1] == '.') {
			++dot;
			if(chk[x][y + 1]) ++ch;
		}
		
		if(dot == ch) return false;
		else return true;
	}
	private static void bfs(int x, int y) {
		for(int i = 0; i < N; i++) Arrays.fill(chk[i], false);
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != '.' || chk[nx][ny])
						continue;
					
					chk[nx][ny] = true;
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