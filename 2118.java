import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] sum = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			sum[i] = sum[i - 1] + num;
		}
		
		if(N == 2) {
			System.out.println(Math.min(sum[1], sum[2] - sum[1]));
			return;
		}
		
		int res = 0;
		for(int i = 1; i < N; i++)
			for(int j = i + 1; j <= N; j++)
				res = Math.max(res, Math.min(sum[j] - sum[i - 1], sum[N] - (sum[j] - sum[i - 1])));
			
		System.out.println(res);
	}
}