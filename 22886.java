import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] dp = new int[2][1000];
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			char[] ch = sc.next().toCharArray();
			
			for(int i = 0; i < 2; i++) Arrays.fill(dp[i], 1000000000);
			
			if(ch[0] == '?') dp[0][0] = dp[1][0] = 0;
			else if(ch[0] == 'C') dp[0][0] = 0;
			else dp[1][0] = 0;
			
			for(int i = 1; i < ch.length; i++) {
				if(ch[i] == 'C') dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1] + Y);//CC, JC
				else if(ch[i] == 'J') dp[1][i] = Math.min(dp[1][i - 1], dp[0][i - 1] + X);//JJ, CJ
				else {
					dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1] + Y);
					dp[1][i] = Math.min(dp[1][i - 1], dp[0][i - 1] + X);
				}
			}
			
			
			int res = Math.min(dp[0][ch.length - 1], dp[1][ch.length - 1]);
			System.out.println("Case #" + test_case + ": " + res);
		}
	}
}