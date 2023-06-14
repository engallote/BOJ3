import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[2][3];
		
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 3; j++)
				arr[i][j] = sc.nextInt();
		
		int res = 0;
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 3; j++)
				res += solve(j, arr[i][j], 1);
		
		System.out.println(res);
	}
	private static int solve(int c, int sum, int cnt) {
		if(cnt == N) {
			if(sum >= M) return 1;
			return 0;
		}
		
		int ret = 0;
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 3; j++) {
				if(c == j) {
					ret += solve(j, sum + arr[i][j] / 2, cnt + 1);
				}
				else ret += solve(j, sum + arr[i][j], cnt + 1);
			}
		
		return ret;
	}
}