import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] army = new int[N + 1];
		boolean[] chk = new boolean[N + 1];
		ArrayList<Integer>[] aly = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			aly[a].add(b);
			aly[b].add(a);
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) army[i] = Integer.parseInt(br.readLine());
		for(int next : aly[1]) {
			pq.offer(new Pair(next, army[next]));
			chk[next] = true;
		}
		
		int res = army[1];
		chk[1] = true;
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.cost >= res) break;
			
			res += p.cost;
			
			for(int next : aly[p.v])
				if(!chk[next]) {
					chk[next] = true;
					pq.offer(new Pair(next, army[next]));
				}
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair> {
	int v, cost;
	Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cost, o.cost);
	}
}