import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			pq.offer(new Pair(a, b));
		}
		
		long res = 0;
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			res += (long)p.a * (long)N + p.b;
			--N;
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair> {
	int a, b;
	Pair(int a, int b){
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.a > o.a) return -1;
		else if(this.a == o.a) return Integer.compare(o.b, this.b);
		else return 1;
	}
}