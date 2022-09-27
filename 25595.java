import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = {1, 1, -1, -1}, dy = {1, -1, 1, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new int[N][N];
    	int x = 0, y = 0;
    	Queue<Integer> q = new LinkedList<>();
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			map[i][j] = sc.nextInt();
    			
    			if(map[i][j] == 2) {
    				map[i][j] = 0;
    				x = i;
    				y = j;
    			}
    			else if(map[i][j] == 1) {
    				map[i][j] = 0;
    				q.offer(i * 1000 + j);
    			}
    		}
    	}
    	
    	bfs(x, y);
    	while(!q.isEmpty()) {
    		int px = q.peek() / 1000, py = q.poll() % 1000;
    		
    		if(px - 1 >= 0 && map[px - 1][py] == 2) continue;
    		if(px + 1 < N && map[px + 1][py] == 2) continue;
    		if(py - 1 >= 0 && map[px][py - 1] == 2) continue;
    		if(py + 1 < N && map[px][py + 1] == 2) continue;
    		
    		System.out.println("Kiriya");
    		return;
    	}
    	
    	System.out.println("Lena");
	}
	private static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x * 1000 + y);
		map[x][y] = 2;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int px = q.peek() / 1000, py = q.poll() % 1000;
				
				for(int i = 0; i < 4; i++) {
					int nx = px + dx[i], ny = py + dy[i];
					
					if(nx < 0 || nx >= N || ny >= N || ny < 0 || map[nx][ny] == 2) continue;
					map[nx][ny] = 2;
					q.offer(nx * 1000 + ny);
				}
			}
		}
	}
}