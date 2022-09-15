import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	Pair[] arr = new Pair[N];
    	PriorityQueue<Pair> pq = new PriorityQueue<>();    	
    	for(int i = 0; i < N; i++) {
    		int s = sc.nextInt();
    		int e = sc.nextInt();
    		
    		arr[i] = new Pair(s, e);
    	}
    	
    	Arrays.sort(arr, new Comparator<Pair>() {
    		@Override
    		public int compare(Pair a, Pair b) {
    			return Integer.compare(a.s, b.s);
    		}
		});

    	int res = 0, a = Integer.MAX_VALUE, b = 0;
    	for(int i = 0; i < N; i++) {
    		Pair p = arr[i];
    		pq.offer(p);
    		
    		Pair p2 = new Pair(-1, -1);
    		while(!pq.isEmpty() && pq.peek().e <= p.s) p2 = pq.poll();
    		
			if(res < pq.size()) {
				res = pq.size();
				a = p.s;
				b = pq.peek().e;
			}
			else if(res == pq.size() && arr[i].s == p2.e) b = pq.peek().e;
    	}
    	
    	System.out.println(res);
    	System.out.println(a + " " + b);
	}
}
class Pair implements Comparable<Pair> {
	int s, e;
	Pair(int s, int e) {
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.e < o.e) return -1;
		else if(this.e == o.e) return Integer.compare(this.s, o.s);
		else return 1;
	}
}