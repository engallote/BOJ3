import java.util.*;

public class Main {
	static int V, E;
	static ArrayList<Integer>[] aly;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		aly = new ArrayList[V + 1];
		chk = new boolean[V + 1][V + 1];
		
		for(int i = 1; i <= V; i++) aly[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			aly[s].add(e);
			aly[e].add(s);
		}
		
		for(int i = 1; i <= V; i++) {
			for(int k = 0; k <= V; k++) Arrays.fill(chk[k], false);
			if(dfs(i, 0)) {
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}
	private static boolean dfs(int a, int cnt) {
		if(cnt == E) return true;
		boolean ret = false;
		
		for(int next : aly[a]) 
			if(!chk[a][next] && !chk[next][a]) {
			chk[a][next] = chk[next][a] = true;
			ret |= dfs(next, cnt + 1);
		}
		
		return ret;
	}
}