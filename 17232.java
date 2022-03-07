import java.util.*;

public class Main {
	static int N, M, T, K, a, b;
	static char[][] map;
	static int[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		K = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		map = new char[N][M];
		chk = new int[N][M + 1];
		
		for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
		sum();
		
		while(--T >= 0) {
			simul();
			sum();
		}
		
		for(int i = 0; i < N; i++)
			System.out.println(new String(map[i]));
	}
	private static void sum() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(chk[i], 0);
			for(int j = 0; j < M; j++) {
				chk[i][j] = map[i][j] == '*' ? 1 : 0;
				if(j > 0) chk[i][j] += chk[i][j - 1];
			}
		}
	}
	private static void simul() {
		char[][] tmp = new char[N][M];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				int sum = 0;
				for(int x = Math.max(i - K, 0); x <= Math.min(i + K, N - 1); x++) {
					sum += chk[x][Math.min(j + K, M - 1)];
					if(j - K <= 0) continue;
					else sum -= chk[x][j - K - 1];
				}
				
				if(map[i][j] == '*' && sum > 0) sum -= 1;
				
				if(map[i][j] == '*') {
					if(a <= sum && sum <= b) tmp[i][j] = '*';
					else tmp[i][j] = '.';
				}
				else {
					if(a < sum && sum <= b) tmp[i][j] = '*';
					else tmp[i][j] = '.';
				}
			}
		
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				map[i][j] = tmp[i][j];
	}
}