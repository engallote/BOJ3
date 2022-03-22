import java.util.*;

public class Main {
	static int p, c;
	static boolean[][] chk;
	static boolean[] visit;
	static ArrayList<Integer>[] aly;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			p = sc.nextInt();
			c = sc.nextInt();
			
			if(p == 0 && c == 0) break;
			
			aly = new ArrayList[p];
			chk = new boolean[p][p];
			visit = new boolean[p];
			
			for(int i = 0; i < p; i++) aly[i] = new ArrayList<>();
			
			for(int i = 0; i < c; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				aly[a].add(b);
				aly[b].add(a);
			}
			
			boolean flag = false;
			for(int i = 0; i < p && !flag; i++)
				for(int j : aly[i])
					if(!chk[i][j]) {
						Arrays.fill(visit, false);
						bfs(i, j);
						
						if(chk[i][j]) {
							flag = true;
							break;
						}
					}
			
			System.out.println(flag ? "Yes" : "No");
		}
	}
	private static void bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		visit[0] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			++cnt;
			
			for(int y : aly[x]) {
				if((x == a && y == b) || (x == b && y == a)) continue;
				if(visit[y]) continue;
				visit[y] = true;
				q.offer(y);
			}
		}
		
		if(cnt < p) chk[a][b] = chk[b][a] = true;
	}
}