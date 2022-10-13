import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static long[] water;
	static ArrayList<Pair>[] aly;
	static long[] chk, have_water;
    public static void main(String[] args) throws NumberFormatException, IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	water = new long[N + 1];
    	aly = new ArrayList[N + 1];
    	chk = new long[N + 1];
    	have_water = new long[N + 1];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= N; i++) {
    		water[i] = Long.parseLong(st.nextToken());
    		aly[i] = new ArrayList<>();
    	}
    	Arrays.fill(chk, Long.MAX_VALUE);
    	
    	int M = Integer.parseInt(br.readLine());
    	while(--M >= 0) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		long c = Long.parseLong(st.nextToken());
    		
    		aly[a].add(new Pair(b, c));
    		aly[b].add(new Pair(a, c));
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int s = Integer.parseInt(st.nextToken());
    	int e = Integer.parseInt(st.nextToken());
    	bfs(s, e);
	}
	private static void bfs(int s, int e) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(s, water[s], 0));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.v == e) {
				System.out.println(p.cnt + " " + p.w);
				return;
			}
			if(chk[p.v] < p.cnt) continue;
			
			for(Pair next : aly[p.v])
				if(chk[next.v] > p.cnt + next.w || (chk[next.v] == p.cnt + next.w && have_water[next.v] < p.w + water[next.v])) {
					chk[next.v] = p.cnt + next.w;
					have_water[next.v] = p.w + water[next.v];
					pq.offer(new Pair(next.v, p.w + water[next.v], p.cnt +  + next.w));
				}
		}
		
		System.out.println(-1);
	}
}
class Pair implements Comparable<Pair> {
	int v;
	long w, cnt;
	Pair(int v, long w) {
		this.v = v;
		this.w = w;
	}
	Pair(int v, long w, long cnt) {
		this.v = v;
		this.w = w;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.cnt < o.cnt) return -1;
		else if(this.cnt == o.cnt) return Long.compare(o.w, this.w);
		else return 1;
	}
}