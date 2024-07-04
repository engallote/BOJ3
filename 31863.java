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
		
		int x = 0, y = 0;
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++) 
				if(map[i][j] == '@') {
					map[i][j] = '.';
					x = i;
					y = j;
				}
		}
		
		bfs(x, y);
		
		int no = 0, yes = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '*' || map[i][j] == '#') no += 1;
				else if(map[i][j] == '-') yes += 1;
			}
		}
		
		System.out.println(yes + " " + no);
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '|')
				continue;
			
			if(map[nx][ny] == '*') {
				map[nx][ny] = '-';
				q.offer(new Pair(nx, ny));
			}
			else if(map[nx][ny] == '#') {
				map[nx][ny] = '*';
			}
			
			nx += dx[i];
			ny += dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '|' || map[nx][ny] == '.' || map[nx][ny] == '-')
				continue;
			
			if(map[nx][ny] == '*') {
				map[nx][ny] = '-';
				q.offer(new Pair(nx, ny));
			}
			else if(map[nx][ny] == '#') {
				map[nx][ny] = '*';
			}
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '|')
						continue;
					
					if(map[nx][ny] == '*') {
						map[nx][ny] = '-';
						q.offer(new Pair(nx, ny));
					}
					else if(map[nx][ny] == '#') {
						map[nx][ny] = '*';
					}
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