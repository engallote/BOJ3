import java.util.*;

public class Main {
	static int N, K, res;
	static ArrayList<Integer>[] tree;
	static int[] arr;
	static boolean[] chk;
	static int[][][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	tree = new ArrayList[N];
    	chk = new boolean[N];
    	arr = new int[N];
    	dp = new int[N][K + 1][N + 1];
    	res = 0;
    	
    	for(int i = 0; i < N; i++) {
    		tree[i] = new ArrayList<>();
    		for(int j = 0; j <= K; j++) Arrays.fill(dp[i][j], -1);
    	}
    	
    	for(int i = 0; i < N - 1; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		tree[a].add(b);
    		tree[b].add(a);
    	}
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	chk[0] = true;
    	dfs(0, 1, arr[0] == 1 ? 1 : 0);
    	System.out.println(res);
	}
	private static void dfs(int idx, int cnt, int sum) {
		if(cnt <= K) res = Math.max(res, sum);
		else if(cnt > K) return;
		if(dp[idx][cnt][sum] != -1) return;
		
		dp[idx][cnt][sum] = 1;
		for(int next : tree[idx]) {
			if(!chk[next]) {
				chk[next] = true;
				if(arr[next] == 0) dfs(next, cnt + 1, sum);
				else dfs(next, cnt + 1, sum + 1);
				chk[next] = false;
			}
			else dfs(next, cnt, sum);
		}
	}
}