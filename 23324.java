import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		par = new int[N + 1];
		long[] cnt = new long[N + 1];
		
		for(int i = 1; i <= N; i++) {
			par[i] = i;
			cnt[i] = 1;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(i == K) continue;
			else pq.offer(new Pair(a, b, 0));
		}
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			int ap = find(p.a), bp = find(p.b);
			
			if(ap == bp) continue;
			
			par[bp] = ap;
			cnt[ap] += cnt[bp];
			cnt[bp] = 0;
		}
		
		long a = 0, b = 0;
		for(int i = 1; i <= N; i++) {
			if(cnt[i] == 0) continue;
			if(a == 0) a = cnt[i];
			else b = cnt[i];
		}
		
		System.out.println(a * b);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair> {
	int a, b, cost;
	Pair(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cost, o.cost);
	}
}