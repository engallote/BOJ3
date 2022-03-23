import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] chk = new boolean[M][N];
		int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
		
		int x = 0, y = 0;
		chk[x][y] = true;
		int d = 0;
		
		while(true) {
			int cnt = 0;
			for(int i = 0; i < 4; i++) {
				if(x + dx[d] >= 0 && x + dx[d] < M && y + dy[d] >= 0 && y + dy[d] < N) {
					if(chk[x + dx[d]][y + dy[d]]) {
						d += 1;
						d %= 4;
					}
					else break;
				}
				else {
					d += 1;
					d %= 4;
				}
				++cnt;
			}
			
			if(cnt == 4) break;
			
			x += dx[d];
			y += dy[d];
			chk[x][y] = true;
		}
		
		System.out.println(y + " " + x);
	}
}