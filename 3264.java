import java.util.*;

public class Main {
	static int N, S;
	static ArrayList<Pair> aly[];
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		aly = new ArrayList[N + 1];
		chk = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			aly[i] = new ArrayList<>();
			chk[i] = 1000000000;
		}
		
		int sum = 0;
		for(int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			sum += c;
			aly[a].add(new Pair(b, c));
			aly[b].add(new Pair(a, c));
		}
		
		bfs();
		
		int sub = 0;
		for(int i = 1; i <= N; i++) {
			if(sub < chk[i]) sub = chk[i];
//			System.out.println(i + " > " + chk[i]);
		}
		
		System.out.println(2 * sum - sub);
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(S, 0));
		chk[S] = 0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(Pair next : aly[p.v])
				if(chk[next.v] > chk[p.v] + next.cost) {
					chk[next.v] = chk[p.v] + next.cost;
					q.offer(new Pair(next.v, chk[next.v]));
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