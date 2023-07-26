import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr = new int[N][M];
		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
		
		int cnt = 0, res = 0;
		boolean flag;
		for(int num = 1; num <= 4; num++) {
			res = num;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] > 0) continue;
					flag = true;
					
					for(int d = 0; d < 8; d++) {
						int nx = i + dx[d], ny = j + dy[d];
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0) continue;
						if(arr[nx][ny] == num) {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						arr[i][j] = num;
						++cnt;
					}
				}
			}
			
			if(cnt == N * M) break;
		}
		
		System.out.println(res);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}