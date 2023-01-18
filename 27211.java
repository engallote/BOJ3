import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	Queue<Pair> zero = new LinkedList<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] == 0) zero.offer(new Pair(i, j));
    		}
    	}
    	
    	int res = 0;
    	while(!zero.isEmpty()) {
    		Pair p = zero.poll();
    		if(map[p.x][p.y] != 0) continue;
    		
    		res += 1;
    		bfs(p.x, p.y);
    	}
    	
    	System.out.println(res);
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		map[x][y] = 1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					
					if(nx < 0) nx = N - 1;
					else if(ny < 0) ny = M - 1;
					else if(nx >= N) nx = 0;
					else if(ny >= M) ny = 0;
					
					if(map[nx][ny] != 0) continue;
					
					map[nx][ny] = 1;
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