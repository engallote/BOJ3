import java.util.*;

public class Main {
	static int F, P, M, C;
	static ArrayList<Pair>[] aly;
	static int[] cow;
	static int[] path;
	static HashSet<Integer> hs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		P = sc.nextInt();
		C = sc.nextInt();//cow
		M = sc.nextInt();//time
		hs = new HashSet<>();
		cow = new int[C + 1];
		aly = new ArrayList[F + 1];
		path = new int[F + 1];
		
		for(int i = 1; i <= F; i++) {
			aly[i] = new ArrayList<>();
			path[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < P; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			aly[a].add(new Pair(b, c));
			aly[b].add(new Pair(a, c));
		}
		
		for(int i = 1; i <= C; i++) cow[i] = sc.nextInt();
		
		bfs();
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= C; i++) {
			if(hs.contains(cow[i])) q.offer(i);
		}
		
		System.out.println(q.size());
		while(!q.isEmpty()) System.out.println(q.poll());
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(1, 0));
		path[1] = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(path[p.v] <= M) hs.add(p.v);
				for(Pair next : aly[p.v]) {
					if(path[next.v] <= p.cost + next.cost) continue;
					path[next.v] = p.cost + next.cost;
					q.offer(new Pair(next.v, p.cost + next.cost));
				}
			}
		}
	}
}
class Pair {
	int v, cost;
	Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}