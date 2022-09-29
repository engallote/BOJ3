import java.util.*;

public class Main {
	static int N, res;
	static int[][] map, path;
	static int[] chk;
	static int[] dx = {1, 1, -1, -1}, dy = {1, -1, 1, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new int[N][N];
    	path = new int[12][12];
    	chk = new int[10];
    	int x = 0, y = 0;
    	ArrayList<Integer> aly = new ArrayList<>();
    	
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
    				aly.add(i * 1000 + j);
    			}
    		}
    	}
    	
    	for(int i = 0; i < aly.size(); i++) {
    		int x1 = aly.get(i) / 1000, y1 = aly.get(i) % 1000;
    		path[i][11] = path[11][i] = bfs(x, y, x1, y1);
    		if(path[i][11] == 1000000000) {
    			System.out.println("Shorei");
    			return;
    		}
    		for(int j = i + 1; j < aly.size(); j++) {
    			int x2 = aly.get(j) / 1000, y2 = aly.get(j) % 1000;
    			path[i][j] = path[j][i] = bfs(x1, y1, x2, y2);
    			if(path[i][j] == 1000000000) {
        			System.out.println("Shorei");
        			return;
        		}
    		}
    	}
    	
    	res = Integer.MAX_VALUE;
    	solve(0, aly.size(), 0, x, y);
    	
    	if(res == Integer.MAX_VALUE) System.out.println("Shorei");
    	else {
    		System.out.println("Undertaker");
    		System.out.println(res);
    	}
	}
	private static void solve(int cnt, int size, int check, int x, int y) {
		if(cnt == size) {
			int sum = 0;
			for(int i = 0; i < size; i++) {
				if(i == 0) sum += path[11][chk[i]];
				else sum += path[chk[i]][chk[i - 1]];
			}
			
			res = Math.min(res, sum);
			return;
		}
		for(int i = 0; i < size; i++)
			if((check&(1<<i)) == 0) {
				chk[cnt] = i;
				solve(cnt + 1, size, check|(1<<i), x, y);
				chk[cnt] = 0;
			}
	}
	private static int bfs(int x1, int y1, int x2, int y2) {
		boolean[] chk = new boolean[1000000];
		Queue<Integer> q = new LinkedList<>();
		q.offer(x1 * 1000 + y1);
		chk[x1 * 1000 + y1] = true;
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int px = q.peek() / 1000, py = q.poll() % 1000;
				
				if(px == x2 && py == y2) return time;
				
				for(int i = 0; i < 4; i++) {
					int nx = px + dx[i], ny = py + dy[i];
					
					if(nx < 0 || nx >= N || ny >= N || ny < 0 || chk[nx * 1000 + ny]) continue;
					chk[nx * 1000 + ny] = true;
					q.offer(nx * 1000 + ny);
				}
			}
			++time;
		}
		return 1000000000;
	}
}