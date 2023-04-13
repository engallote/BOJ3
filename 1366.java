import java.util.*;

public class Main {
	static int N, M, res;
	static String[] str, m;
	static HashMap<String, Integer> hm;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		hm = new HashMap<>();
		
		hm.put("A", 0);
		hm.put("A#", 1);
		hm.put("B", 2);
		hm.put("C", 3);
		hm.put("C#", 4);
		hm.put("D", 5);
		hm.put("D#", 6);
		hm.put("E", 7);
		hm.put("F", 8);
		hm.put("F#", 9);
		hm.put("G", 10);
		hm.put("G#", 11);
		
		str = sc.nextLine().split(" ");
		m = sc.nextLine().split(" ");
		
		res = Integer.MAX_VALUE;
		int[][] arr = new int[N][2];
		solve(0, arr);
		
		System.out.println(res);
	}
	private static void solve(int cnt, int[][] arr) {
		if(res == 0) return;
		if(cnt == N) {
			int mx = -1, mn = 1000000;
			int chk = 0;
			
			for(int i = 0; i < N; i++) {
				if((chk&(1<<arr[i][0])) == 0) chk |= (1<<arr[i][0]);
				
				if(arr[i][1] != 0) {
					mx = Math.max(mx, arr[i][1]);
					mn = Math.min(mn, arr[i][1]);
				}
			}
			
			if(chk == (1<<M) - 1) {
				if(mx == -1) res = 0;
				else res = Math.min(res, mx - mn + 1);
			}
			return;
		}
		
		for(int i = 0; i < M; i++) {
			arr[cnt][0] = i;
			arr[cnt][1] = hm.get(str[cnt]) - hm.get(m[i]) + (hm.get(str[cnt]) >= hm.get(m[i]) ? 0 : 12);
			
			solve(cnt + 1, arr);
			
			arr[cnt][1] += 12;
			solve(cnt + 1, arr);
		}
	}
}