import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] map = new char[N][M];
			
			for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
			
			if(map[0][0] == 'O') {
				Queue<Pair> q = new LinkedList<>();
				q.offer(new Pair(0, 0));
				while(!q.isEmpty()) {
					Pair p = q.poll();
					
					if(map[p.x][p.y] == 'M') continue;
					map[p.x][p.y] = 'M';
					
					for(int i = 0; i < 4; i++) {
						int nx = p.x + dx[i], ny = p.y + dy[i];
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'X' || map[nx][ny] == 'M') continue;
						q.offer(new Pair(nx, ny));
					}
				}
			}
			
			int len = M * 4;
			StringBuilder sb = new StringBuilder();
			sb.append("Case: " + test_case + "\n");
			for(int i = 0; i <= len; i++) {
				if(i % 4 == 0) sb.append('+');
				else sb.append('-');
			}
			sb.append("\n");
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					sb.append("|");
					if(map[i][j] == 'O') sb.append("   ");
					else sb.append(" " + map[i][j] + " ");
				}
				sb.append("|\n");
				for(int k = 0; k <= len; k++) {
					if(k % 4 == 0) sb.append('+');
					else sb.append('-');
				}
				sb.append("\n");
			}
			
			if(map[N - 1][M - 1] == 'M') sb.append("Minions can cross the room");
			else sb.append("Minions cannot cross the room");
			System.out.println(sb.toString());
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