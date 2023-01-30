import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] aly;
	static boolean[][] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	aly = new ArrayList[N];
    	chk = new boolean[N][10];
    	Queue<Integer> q = new LinkedList<>();
    	
    	for(int i = 0; i < N; i++) aly[i] = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		int cnt = sc.nextInt();
    		
    		for(int j = 0; j < cnt; j++) {
    			int num = sc.nextInt();
    			if(num == 0) q.offer(i);
    			aly[i].add(num);
    		}
    	}
    	
    	int end = sc.nextInt();
    	int res = Integer.MAX_VALUE;
    	
    	while(!q.isEmpty()) {
    		int start = q.poll();
    		
    		res = Math.min(res, bfs(start, end));
    	}
    	
    	System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
	private static int bfs(int start, int end) {
		for(int i = 0; i < N; i++) Arrays.fill(chk[i], false);
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(start, 0, 0));
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				if(p.cur == end) return p.cnt;
				
				for(int i = 0; i < aly[p.v].size(); i++)
					if(!chk[p.v][i]) {
						chk[p.v][i] = true;
						q.offer(new Pair(p.v, aly[p.v].get(i), p.cnt));
					}
				
				for(int i = 0; i < N; i++)
					if(p.v != i) {
						for(int j = 0; j < aly[i].size(); j++)
							if(aly[i].get(j) == p.cur && !chk[i][j]) {
								chk[i][j] = true;
								q.offer(new Pair(i, aly[i].get(j), p.cnt + 1));
							}
					}
			}
		}
		
		return Integer.MAX_VALUE;
	}
}
class Pair {
	int v, cur, cnt;
	Pair(int v, int cur, int cnt) {
		this.v = v;
		this.cur = cur;
		this.cnt = cnt;
	}
}