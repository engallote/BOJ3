import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		par = new int[N + 1];
		long[] size = new long[N + 1];
		
		for(int i = 1; i <= N; i++) par[i] = i;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())));
		}
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		long res = 0l;
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			int ap = find(p.a), bp = find(p.b);
			
			if(ap == bp) continue;
			
			par[bp] = ap;
			
			sb.append(p.num);
			
			res += p.cost;
			cnt += 1;
			
			if(cnt >= N) break;
		}
		
		if(cnt != N - 1) bw.write("-1");
		else bw.write(sb.toString() + " " + res);
		
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair> {
	int a, b, num;
	long cost;
	Pair(int a, int b, int num, long cost) {
		this.a = a;
		this.b = b;
		this.num = num;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.num < o.num) return -1;
		else if(this.num == o.num) return Long.compare(this.cost, o.cost);
		else return 1;
	}
}