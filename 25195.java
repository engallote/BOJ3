import java.util.*;

public class Main {
	static int N, M;
	static boolean flag;
	static ArrayList<Integer>[] aly;
	static boolean[] fan, chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		aly = new ArrayList[N + 1];
		fan = new boolean[N + 1];
		chk = new boolean[N + 1];
		flag = false;
		
		for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			aly[s].add(e);
		}
		
		int Q = sc.nextInt();
		for(int i = 0; i < Q; i++) {
			int num = sc.nextInt();
			fan[num] = true;
		}
		
		if(fan[1]) {
			System.out.println("Yes");
			return;
		}
		
		dfs(1);
		
		System.out.println(flag ? "yes" : "Yes");
	}
	private static void dfs(int idx) {
		if(flag) return;
		if(aly[idx].size() == 0) {
			flag = true;
			return;
		}
		if(chk[idx]) return;
		chk[idx] = true;
		
		for(int next : aly[idx])
			if(!fan[next]) dfs(next);
		
		chk[idx] = false;
	}
}