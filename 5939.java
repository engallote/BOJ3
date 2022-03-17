import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) pq.offer(new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			System.out.println(p.h + " " + p.m + " " + p.s);
		}
	}
}
class Pair implements Comparable<Pair> {
	int h, m, s;
	Pair(int h, int m, int s){
		this.h = h;
		this.m = m;
		this.s = s;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.h > this.h) return -1;
		else if(o.h == this.h) {
			if(o.m > this.m) return -1;
			else if(o.m == this.m) return Integer.compare(this.s, o.s);
			else return 1;
		}
		else return 1;
	}
}