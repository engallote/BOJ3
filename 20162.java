import java.util.*;

public class Main {
	static int N;
	static int[] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N];
		
		Arrays.fill(dp, -1);
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int res = solve(0, 0, 0);
		System.out.println(res);
	}
	private static int solve(int idx, int pre, int max) {
		if(idx == N) return 0;
		if(dp[idx] != -1) return dp[idx];
		int ret = 0;
		
		for(int i = idx; i < N; i++)
			if(max < arr[i]) ret = Math.max(ret, solve(i, idx, arr[i]) + arr[i]);
		
		return dp[idx] = ret;
	}
}