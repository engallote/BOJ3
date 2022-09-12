import java.util.*;

public class Main {
	static int N, x, y;
	static int[] arr;
	static boolean[] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	x = sc.nextInt() - 1;
    	y = sc.nextInt() - 1;
    	arr = new int[2 * N];
    	chk = new boolean[N + 1];
    	
    	arr[x] = arr[y] = y - x - 1;
    	chk[y - x - 1] = true;
    	
    	int res = solve(0);
    	System.out.println(res);
	}
	private static int solve(int idx) {
		if(idx == 2 * N) return 1;
		int ret = 0;
		
		if(arr[idx] != 0) ret += solve(idx + 1);
		else {
			for(int i = 1; i <= N; i++)
				if(!chk[i])
					if(idx + i + 1 < 2 * N && arr[idx + i + 1] == 0) {
						chk[i] = true;
						arr[idx] = i;
						arr[idx + i + 1] = i;
						ret += solve(idx + 1);
						arr[idx] = 0;
						arr[idx + i + 1] = 0;
						chk[i] = false;
					}
		}
		
		return ret;
	}
}