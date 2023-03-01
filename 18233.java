import java.util.*;

public class Main {
	static int N, P, E;
	static boolean flag;
	static int[][] arr;
	static int[] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		P = sc.nextInt();
		E = sc.nextInt();
		arr = new int[N][2];
		ans = new int[N];
		flag = false;
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			max += arr[i][1];
		}
		
		if(N < P || max < E) {
			System.out.println(-1);
			return;
		}
		
		ArrayList<Integer> p = new ArrayList<>();
		findP(0, 0, p);
		
		if(flag) {
			for(int i = 0; i < N; i++) System.out.print(ans[i] + " ");
		}
		else System.out.println(-1);
	}
	private static void findP(int idx, int cnt, ArrayList<Integer> p) {
		if(flag) return;
		if(cnt == P) {
			solve(p);
			return;
		}
		if(idx >= N) return;
		
		findP(idx + 1, cnt, p);
		p.add(idx);
		findP(idx + 1, cnt + 1, p);
		p.remove(p.size() - 1);
	}
	private static void solve(ArrayList<Integer> p) {
		int res = E, min = 0, max = 0;
		Arrays.fill(ans, 0);
		
		for(int i : p) {
			min += arr[i][0];
			max += arr[i][1];
		}
		
		if(min <= E && E <= max) {
			flag = true;
			for(int i : p) {
				ans[i] = arr[i][0];
				res -= arr[i][0];
			}
			
			for(int i : p) {
				if(res >= arr[i][1] - arr[i][0]) {
					ans[i] = arr[i][1];
					res -= arr[i][1] - arr[i][0];
				}
				else {
					ans[i] += res;
					res = 0;
				}
			}
			
		}
	}
}