import java.util.*;

public class Main {
	static int N, M;
	static long[][] arr1, arr2, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr1 = new long[N][M];
		arr2 = new long[N][M];
		dp = new long[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				arr1[i][j] = sc.nextLong();
				Arrays.fill(dp[i], -1);
			}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) arr2[i][j] = sc.nextLong();
		
		for(int i = 0; i < M; i++) solve(0, i);
		
		long res = Long.MAX_VALUE;
		for(int i = 0; i < M; i++) res = Math.min(res, dp[0][i]);
		
		System.out.println(res);
	}
	private static long solve(int x, int y) {
		if(x == N) return 0;
		if(dp[x][y] != -1) return dp[x][y];
		
		long ret = solve(x + 1, y);
		
		if(y - 1 >= 0) ret = Math.min(ret, solve(x + 1, y - 1));
		if(y + 1 < M) ret = Math.min(ret, solve(x + 1, y  + 1));
		
		return dp[x][y] = ret + Math.abs(arr1[x][y] - arr2[x][y]) * Math.abs(arr1[x][y] - arr2[x][y]);
	}
}