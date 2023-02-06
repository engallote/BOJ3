import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, chk;
	static boolean[][] visit;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new int[N][M];
    	chk = new int[N][M];
    	visit = new boolean[N][M];
    	Queue<Pair> q = new LinkedList<>();
    	
    	for(int i = 0; i < N; i++) {
    		char[] ch = sc.next().toCharArray();
    		for(int j = 0; j < M; j++) {
    			map[i][j] = ch[j] - '0';
    			chk[i][j] = map[i][j];
    			
    			if(map[i][j] > 0) q.offer(new Pair(i, j, map[i][j]));
    		}
    	}
    	    
    	if(check()) {
    		System.out.println(0);
    		return;
    	}
    	
    	int res = 0;
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(--size >= 0) {
    			Pair p = q.poll();
        		
        		if(chk[p.x][p.y] > p.k) continue;
        		
        		int num = (p.k * 2 + 1) / 2;
        		for(int i = Math.max(0, p.x - num); i < Math.min(N, p.x + num + 1); i++)
        			for(int j = Math.max(0, p.y - num); j < Math.min(M, p.y + num + 1); j++)
        				if(chk[i][j] < p.k) {
        					chk[i][j] = p.k;
        					q.offer(new Pair(i, j, p.k));
        				}
    		}
    		    		
        	++res;
    		if(check()) break;
    	}
    	
    	System.out.println(res);
	}
    private static boolean check() {
    	for(int i = 0; i < N; i++) Arrays.fill(visit[i], false);
    	
    	int cnt = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(chk[i][j] != 0 && !visit[i][j]) {
					bfs(i, j);
					++cnt;
					
					if(cnt > 1) return false;
				}
		return true;
	}
	private static void bfs(int x, int y) {		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || chk[nx][ny] == 0)
					continue;
				
				visit[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
	}
}
class Pair {
	int x, y, k;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}
}