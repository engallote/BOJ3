import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = {1, 0}, dy = {0, 1};
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		dp = new int[N + 1][M + 1];
		
		dp[1][1] = 1;
		for(int i = 1; i <= x; i++)
			for(int j = 1; j <= y; j++) {
				dp[i][j] += dp[i - 1][j];
				dp[i][j] += dp[i][j - 1];
				dp[i][j] %= 1000007;
			}
		
		for(int i = x; i <= N; i++)
			for(int j = y; j <= M; j++) {
				if(i > x) dp[i][j] += dp[i - 1][j];
				if(j > y) dp[i][j] += dp[i][j - 1];
				dp[i][j] %= 1000007;
			}
		
		System.out.println(dp[N][M]);
	}
}