import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	arr = new int[5][5];
    	chk = new int[5][5];
    	
    	for(int i = 0; i < 5; i++)
    		for(int j = 0; j < 5; j++) {
    			arr[i][j] = sc.nextInt();
    			chk[i][j] = 1000000000;
    		}
    	
    	int x = sc.nextInt();
    	int y = sc.nextInt();
    	
    	bfs(x, y);
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
//				System.out.println(p.x + " " + p.y);
				if(arr[p.x][p.y] == 1) {
					System.out.println(chk[p.x][p.y]);
					return;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
					if(arr[nx][ny] != -1 && chk[nx][ny] > chk[p.x][p.y] + 1) {
						chk[nx][ny] = chk[p.x][p.y] + 1;
						q.offer(new Pair(nx, ny));
					}
					
					while(true) {
						if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
							nx -= dx[i];
							ny -= dy[i];
							break;
						}
						if(arr[nx][ny] == -1) {
							nx -= dx[i];
							ny -= dy[i];
							break;
						}
						if(arr[nx][ny] == 7) break;
						
						nx += dx[i];
						ny += dy[i];
					}
					
					if(chk[nx][ny] <= chk[p.x][p.y] + 1) continue;
					chk[nx][ny] = chk[p.x][p.y] + 1;
					q.offer(new Pair(nx, ny));
				}
			}
//			System.out.println("========");
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