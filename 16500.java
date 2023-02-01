import java.util.*;

public class Main {
	static char[] ch;
	static int N;
	static char[][] arr;
	static int[][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	ch = sc.next().toCharArray();
    	N = sc.nextInt();
    	arr = new char[N][];
    	dp = new int[200][200];
    	
    	for(int i = 0; i < 200; i++) Arrays.fill(dp[i], -1);
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.next().toCharArray();
    	
    	int res = solve(0, 0);
    	System.out.println(res);
	}
	private static int solve(int idx, int p) {
		if(idx >= ch.length) return  1;
		if(dp[idx][p] != -1) return dp[idx][p];
		int ret = 0;
		
		for(int i = 0; i < N; i++)
			if(arr[i][0] == ch[idx]) {
				int j, tmp = idx;
				for(j = 0; j < arr[i].length && tmp < ch.length; j++) {
					if(arr[i][j] != ch[tmp]) break;
					tmp += 1;
				}
				
				if(j == arr[i].length) ret = Math.max(ret, solve(idx + j, j));
			}
		
		return dp[idx][p] =  ret;
	}
}