import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	arr = new int[5][5];
    	chk = new boolean[5][5][1<<7];
    	
    	for(int i = 0; i < 5; i++)
    		for(int j = 0; j < 5; j++) arr[i][j] = sc.nextInt();
    	
    	int x = sc.nextInt();
    	int y = sc.nextInt();
    	
    	bfs(x, y);
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y, 0));
		chk[x][y][0] = true;
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
//				System.out.println(p.x + " " + p.y + " " + p.key);
				
				if(p.key == 126) {
					System.out.println(time);
					return;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || arr[nx][ny] == -1) continue;
					int num = arr[nx][ny];
					if(num == 0) {
						if(chk[nx][ny][p.key]) continue;
						chk[nx][ny][p.key] = true;
						q.offer(new Pair(nx, ny, p.key));
					}
					else {
						int nKey = p.key;
						if((p.key&(1<<arr[nx][ny])) == 0) nKey |= (1<<arr[nx][ny]);
						if(chk[nx][ny][nKey]) continue;
						chk[nx][ny][nKey] = true;
						q.offer(new Pair(nx, ny, nKey));
					}
				}
				
			}
			++time;
		}
		System.out.println(-1);
	}
}
class Pair {
	int x, y, key;
	Pair(int x, int y, int key) {
		this.x = x;
		this.y = y;
		this.key = key;
	}
}