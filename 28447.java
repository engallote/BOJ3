import java.util.*;

public class Main {
	static int N, K, res;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		
		res = -1000000;
		solve(0, 0, 0);
		System.out.println(res);
	}
	private static void solve(int cnt, int idx, int chk) {
		if(cnt == K) {
			boolean[][] check = new boolean[N][N];
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if((chk&(1<<i)) == 0) continue;
				
				for(int j = 0; j < N; j++)
					if(i != j && (chk&(1<<j)) != 0) {
						if(check[i][j]) continue;
						sum += arr[i][j];
						check[i][j] = check[j][i] = true;
					}
			}
			
			res = Math.max(res, sum);
			return;
		}
		if(idx == N) return;
		
		for(int i = idx; i < N; i++) {
			if((chk&(1<<i)) != 0) continue;
			
			solve(cnt + 1, i + 1, chk|(1<<i));
		}
	}
}