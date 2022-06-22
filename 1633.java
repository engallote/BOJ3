import java.util.*;

public class Main {
	static int idx = 0;
	static int[] w = new int[1001], b = new int[1001];
	static int[][][] dp = new int[1001][16][16];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			w[idx] = sc.nextInt();
			b[idx] = sc.nextInt();
			++idx;
		}
		
		for(int i = 0; i <= 1000; i++)
			for(int j = 0; j <= 15; j++) Arrays.fill(dp[i][j], -1);
		
		int res = solve(0, 0, 0);
		System.out.println(res);
	}
	private static int solve(int cnt, int ww, int bb) {
		if(ww == 15 && bb == 15) return 0;
		if(cnt == idx) return 0;
		if(dp[cnt][ww][bb] != -1) return dp[cnt][ww][bb];
		
		int ret = solve(cnt + 1, ww, bb);
		
		if(ww + 1 <= 15) ret = Math.max(ret, solve(cnt + 1, ww + 1, bb) + w[cnt]);
		if(bb + 1 <= 15) ret = Math.max(ret, solve(cnt + 1, ww, bb + 1) + b[cnt]);
		
		return dp[cnt][ww][bb] = ret;
	}
}