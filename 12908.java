import java.util.*;

public class Main {
	static long[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sx = sc.nextLong();
		long sy = sc.nextLong();
		long ex = sc.nextLong();
		long ey = sc.nextLong();
		arr = new long[3][4];
		
		for(int i = 0; i < 3; i++) {
			arr[i][0] = sc.nextLong();
			arr[i][1] = sc.nextLong();
			arr[i][2] = sc.nextLong();
			arr[i][3] = sc.nextLong();
		}
		
		long res = Math.abs(sx - ex) + Math.abs(sy - ey);
		
		res = Math.min(res, dfs(sx, sy, ex, ey, 0));
		
		System.out.println(res);
	}
	private static long dfs(long x, long y, long ex, long ey, int chk) {
		if(x == ex && y == ey) return 0;
		long ret = Math.abs(x - ex) + Math.abs(y - ey);
		
		for(int i = 0; i < 3; i++)
			if((chk&(1<<i)) == 0) {
				long a = Math.abs(x - arr[i][0]) + Math.abs(y - arr[i][1]);
				long b = Math.abs(x - arr[i][2]) + Math.abs(y - arr[i][3]);
				
				if(a < b) ret = Math.min(ret, dfs(arr[i][2], arr[i][3], ex, ey, chk|(1<<i)) + 10 + a);
				else ret = Math.min(ret, dfs(arr[i][0], arr[i][1], ex, ey, chk|(1<<i)) + 10 + b);
			}
		
		return ret;
	}
}