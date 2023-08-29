import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		int[][] arr = new int[N][N];
		int[] dx = {-1, 0, 0, 1, 1, -1, -1}, dy = {0, 1, -1, 1, -1, 1, -1};
		
		int x = 0, y = 0;
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			Arrays.fill(arr[i], 100000000);
			for(int j = 0; j < N; j++)
				if(map[i][j] == 'F') {
					arr[i][j] = 0;
					x = i;
					y = j;
				}
		}
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		
		int res = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i = 0; i < 7; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] <= arr[x][y] + 1 || map[nx][ny] == '#') 
					continue;
				
				arr[nx][ny] = arr[x][y] + 1;
				q.offer(new Pair(nx, ny));
			}
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(arr[i][j] != 100000000 && arr[i][j] != 0) res += 1;
		
		System.out.println(res);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}