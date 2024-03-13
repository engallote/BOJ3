import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int K = sc.nextInt();
		arr = new int[N][M];
		
		for(int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 9;
		}
		
		bfs();
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, 0));
		arr[0][0] = 1;
		
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == M - 1) {
					System.out.println(time);
					return;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] > 0) continue;
					arr[nx][ny] = 1;
					q.offer(new Pair(nx, ny));
				}
				
				if(p.x % 2 == 0) {
					if(p.x - 1 >= 0 && p.y - 1 >= 0 && arr[p.x - 1][p.y - 1] == 0) {
						arr[p.x - 1][p.y - 1] = 1;
						q.offer(new Pair(p.x - 1, p.y - 1));
					}
					if(p.x + 1 < N && p.y - 1 >= 0 && arr[p.x + 1][p.y - 1] == 0) {
						arr[p.x + 1][p.y - 1] = 1;
						q.offer(new Pair(p.x + 1, p.y - 1));
					}
				}
				else {
					if(p.x - 1 >= 0 && p.y + 1 < M && arr[p.x - 1][p.y + 1] == 0) {
						arr[p.x - 1][p.y + 1] = 1;
						q.offer(new Pair(p.x - 1, p.y + 1));
					}
					if(p.x + 1 < N && p.y + 1 < M && arr[p.x + 1][p.y + 1] == 0) {
						arr[p.x + 1][p.y + 1] = 1;
						q.offer(new Pair(p.x + 1, p.y + 1));
					}
				}
			}
			++time;
		}
		
		System.out.println(-1);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}