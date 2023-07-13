import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int[] dp = new int[M + 1];
		
		for(int i = 0; i < N; i++)
			for(int j = M; j >= arr[i][0]; j--)
				dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
		
		System.out.println(dp[M]);
	}
}