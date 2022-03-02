import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N], dp = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		for(int i = 0; i < N; i++){
			dp[i] = 1;
			for(int j = 0; j < i; j++)
				if(arr[i] < arr[j] && dp[j] + 1 > dp[i])
					dp[i] = dp[j] + 1;
		}
		
		int res = dp[0];
		
		for(int i = 0; i < N; i++)
			if(res < dp[i]) res = dp[i];
		
		System.out.println(N - res);
	}
}