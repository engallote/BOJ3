import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++) {
    		String str = sc.next().toUpperCase();
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		pq.offer(new Pair(str, a, b));
    	}
    	
    	StringBuilder sb  = new StringBuilder();
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		
    		sb.append(p.str.charAt(p.d - 1));
    	}
    	
    	System.out.println(sb);
	}
}
class Pair implements Comparable<Pair> {
	int i, d;
	String str;
	Pair(String str, int i, int d) {
		this.str = str;
		this.i = i;
		this.d = d;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.i, o.i);
	}
}