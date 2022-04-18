import java.util.*;

public class Main {
	static boolean end = false;
	static int N, M;
	static int[][] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M][2];
		chk = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		solve(1);
		
		if(!end) System.out.println(0);
	}
	private static void solve(int idx) {
		if(end) return;
		if(idx > N) {
			boolean ret = true;
			for(int i = 0; i < M; i++) {
				boolean a, b;
				int idx1 = 0, idx2 = 0;
				idx1 = Math.abs(arr[i][0]);
				idx2 = Math.abs(arr[i][1]);
				
				a = arr[i][0] > 0 ? chk[idx1] : !chk[idx1];
				b = arr[i][1] > 0 ? chk[idx2] : !chk[idx2];
				
				if(a || b) ret = true;
				else {
					ret = false;
					break;
				}
			}
			
			if(ret) {
				System.out.println(1);
				end = true;
			}
			return;
		}
		
		chk[idx] = true;
		solve(idx + 1);
		chk[idx] = false;
		solve(idx + 1);
	}
}