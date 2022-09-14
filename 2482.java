import java.util.*;

public class Main {
	static int mod = 1000000003;
	static int[][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	dp = new int[N + 1][K + 1];
    	
    	if(K > N / 2) {
    		System.out.println(0);
    		return;
    	}
    	if(K == 1) {
    		System.out.println(N);
    		return;
    	}
    	
    	for(int i = 0; i <= N; i++) Arrays.fill(dp[i], -1);
    	
    	int res = solve(N, K);
    	System.out.println(res);
	}

	private static int solve(int n, int k) {
		if(k == 1) return n;
		if(n <= 0 || n < k * 2) return 0;
		if(dp[n][k] != -1) return dp[n][k];
		
		return dp[n][k] = (solve(n - 2, k - 1) + solve(n - 1, k)) % mod;
	}
}