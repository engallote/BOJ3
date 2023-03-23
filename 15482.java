import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s1 = sc.next().toCharArray();
		char[] s2 = sc.next().toCharArray();
		int[][] dp = new int[s1.length + 1][s2.length + 1];
		
		for(int i = 0; i < s1.length; i++)
			for(int j = 0; j < s2.length; j++) {
				if(s1[i] == s2[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
				else dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
			}
		
		System.out.println(dp[s1.length][s2.length]);
	}
}