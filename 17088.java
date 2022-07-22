import java.util.*;

public class Main {
	static int N, res;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		res = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		for(int i = -1; i <= 1; i++)
			for(int j = -1; j <= 1; j++)
				dfs(2, (i == 0 ? 0 : 1) + (j == 0 ? 0 : 1), arr[1] + i, (arr[1] + i) - (arr[0] + j));
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

	private static void dfs(int idx, int cnt, int num, int mid) {
		if(res <= cnt) return;
		if(idx >= N) {
			res = Math.min(res, cnt);
			return;
		}
		
		if(arr[idx] - num == mid) dfs(idx + 1, cnt, arr[idx], mid);
		else if(arr[idx] - 1 - num == mid) dfs(idx + 1, cnt + 1, arr[idx] - 1, mid);
		else if(arr[idx] + 1 - num == mid) dfs(idx + 1, cnt + 1, arr[idx] + 1, mid);
	}
}