import java.util.*;

public class Main {
	static int N, M;
	static int[] arr, arr2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1];
		arr2 = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
			arr2[i] = arr2[i - 1] + arr[i];
		}
		
		if(N == M) {
			System.out.println(arr2[N]);
			return;
		}
		
		int res = dfs(1, 0, 0);
		System.out.println(res);
	}
	private static int dfs(int idx, int m, int sum) {
		if(m == M) return sum;
		
		int res = Integer.MIN_VALUE;
		
		for(int i = idx; i <= N; i++)
			for(int j = i; j <= N; j++)
				res = Math.max(res, dfs(j + 1, m + 1, sum + (arr2[j] - arr2[i - 1])));
		
		return res;
	}
}