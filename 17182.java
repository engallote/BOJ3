import java.util.*;

public class Main {
	static int N, K;
	static int[][] map, arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				arr[i][j] = map[i][j];
			}
		}
		
		for(int k = 0; k < N; k++)
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
		System.out.println(solve(K, (1<<K)));
	}
	private static int solve(int idx, int chk) {
		if(chk == (1 << N) - 1) return 0;
		
		int ret = 100000000;
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0)
				ret = Math.min(ret, solve(i, chk | (1 << i)) + arr[idx][i]);
		
		return ret;
	}
}