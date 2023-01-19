import java.util.*;

public class Main {
	static boolean flag = false;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	map = new int[5][5];
    	
    	for(int i = 0; i < 5; i++)
    		for(int j = 0; j < 5; j++) map[i][j] = sc.nextInt();
    	
    	int r = sc.nextInt();
    	int c = sc.nextInt();
    	
    	dfs(r, c, map[r][c] == 1 ? 1 : 0, 0);
    	System.out.println(flag ? 1 : 0);
	}
	private static void dfs(int r, int c, int apple, int cnt) {
		if(flag) return;
		if(cnt > 3) return;
		if(apple == 2) {
			flag = true;
			return;
		}
		
		int tmp = map[r][c];
		map[r][c] = -1;
		
		for(int i = 0; i < 4; i++) {
			int nx = r + dx[i], ny = c + dy[i];
			if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || map[nx][ny] == -1) continue;
			
			if(map[nx][ny] == 1) dfs(nx, ny, apple + 1, cnt + 1);
			else dfs(nx, ny, apple, cnt + 1);	
		}
		
		map[r][c] = tmp;
	}
}