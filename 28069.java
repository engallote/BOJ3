import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] dp = new int[N + 1];
		
		Arrays.fill(dp, 100000000);
		dp[1] = 1;
		
		for(int i = 1; i <= N; i++) {
			if(i + 1 <= N) dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
			if(i + i / 2 <= N) dp[i + i / 2] = Math.min(dp[i + i / 2], dp[i] + 1);
		}
		
		System.out.println(dp[N] <= K ? "minigimbob" : "water");
	}
}