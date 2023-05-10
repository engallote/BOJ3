import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M + 1];
		dp = new int[N][M + 1];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
			for(int j = 1; j <= M; j++) arr[i][j] = sc.nextInt();
		}
		
		int res = solve(0, 0);
		System.out.println(res);
	}
	private static int solve(int idx, int cur) {
		if(idx == N) return 0;
		if(dp[idx][cur] != -1) return dp[idx][cur];
		int ret = 10000000;
		
		for(int i = 1; i <= M; i++)
			if(cur != i) ret = Math.min(ret, solve(idx + 1, i) + arr[idx][i]);
		return dp[idx][cur] = ret;
	}
}