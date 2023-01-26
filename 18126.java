import java.util.*;

public class Main {
	static int N;
	static long[] arr;
	static ArrayList<Pair> aly[];
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new long[N + 1];
    	aly = new ArrayList[N + 1];
    	
    	for(int i = 1; i <= N; i++) {
    		aly[i] = new ArrayList<>();
    		arr[i] = Long.MAX_VALUE;
    	}
    	
    	for(int i = 0; i < N - 1; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int c = sc.nextInt();
    		aly[a].add(new Pair(b, c));
    		aly[b].add(new Pair(a, c));
    	}
    	
    	bfs();
    	
    	long max = -1;
    	for(int i = 1; i <= N; i++) if(max < arr[i]) max = arr[i];
    	
    	System.out.println(max);
	}
	private static void bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(arr[p.v] <= p.cost) continue;
			
			arr[p.v] = p.cost;
			for(Pair next : aly[p.v])
				pq.offer(new Pair(next.v, next.cost + p.cost));
		}
	}
}
class Pair implements Comparable<Pair> {
	int v;
	long cost;
	Pair(int v, long cost) {
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return Long.compare(o.cost, o.cost);
	}
}