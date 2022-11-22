import java.util.*;

public class Main {
	static int N, K, res, apple, pear;
	static ArrayList<Integer>[] tree;
	static int[] arr;
	static boolean[] chk;
	static int[][][][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	tree = new ArrayList[N];
    	arr = new int[N];
    	chk = new boolean[N];
    	dp = new int[N][K + 1][N + 1][N + 1];
    	res = -1;
    	apple = -1;
    	pear = -1;
    	
    	for(int i = 0; i < N; i++) {
    		tree[i] = new ArrayList<>();
    		for(int j = 0; j <= K; j++)
    			for(int k = 0; k <= N; k++) Arrays.fill(dp[i][j][k], -1);
    	}
    	
    	for(int i = 0; i < N - 1; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		tree[a].add(b);
    		tree[b].add(a);
    	}
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	chk[0] = true;
    	solve(0, 1, arr[0] == 1 ? 1 : 0, arr[0] == 2 ? 1 : 0);
    	System.out.println(apple + " " + pear);
	}
	private static void solve(int idx, int k, int ap, int pe) {
		if(k == K) {
			if(ap * pe > res) {//사과의 개수 × 배의 개수가 최대
				res = ap * pe;
				apple = ap;
				pear = pe;
			}
			else if(ap * pe == res && ap > apple) {//1 && 사과의 개수가 더 많은 경우
				apple = ap;
				pear = pe;
			}
			else if(ap * pe == res && ap == apple && pe > pear) {//2 && 배의 개수가 더 많은 경우
				apple = ap;
				pear = pe;
			}
			return;
		}
		if(dp[idx][k][ap][pe] != -1) return;
		
		dp[idx][k][ap][pe] = 1;
		
		for(int next : tree[idx]) {
			if(chk[next]) solve(next, k, ap, pe);
			else {
				chk[next] = true;
				solve(next, k + 1, ap + (arr[next] == 1 ? 1 : 0), pe + (arr[next] == 2 ? 1 : 0));
				chk[next] = false;
			}
		}
	}
}