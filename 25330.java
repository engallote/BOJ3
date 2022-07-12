import java.util.*;

public class Main {
	static int N;
	static int[] arr, h;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = sc.nextInt();
		arr = new int[N];
		h = new int[N];
		chk = new boolean[N];
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		for(int i = 0; i < N; i++) h[i] = sc.nextInt();
		
		int res = solve(K, 0);
		System.out.println(res);
	}
	private static int solve(int k, int pre) {
		if(k == 0) return 0;
		int ret = 0;
		
		for(int i = 0; i < N; i++)
			if(!chk[i] && k >= arr[i] + pre) {
				chk[i] = true;
				ret = Math.max(ret, solve(k - (arr[i] + pre), pre + arr[i]) + h[i]);
				chk[i] = false;
			}
		
		return ret;
	}
}