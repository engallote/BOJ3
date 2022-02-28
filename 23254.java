import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int time = N * 24;
		int[] arr = new int[M];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int res = 0;
		
		for(int i = 0; i < M; i++) arr[i] = sc.nextInt();
		for(int i = 0; i < M; i++) {
			int num = sc.nextInt();
			res += arr[i];
			pq.offer(new Pair(100 - arr[i], num));
		}
		
		while(time > 0 && !pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.score <= 0) continue;
			int div = p.score / p.b;
			
			if(div == 0) {
				pq.offer(new Pair(p.score, p.score));
				continue;
			}
			if(div <= time) time -= div;
			else {
				div = time;
				time = 0;
			}
			
			res += div * p.b > p.score ? p.score : div * p.b;
			pq.offer(new Pair(p.score - div * p.b, p.b));
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair> {
	int score, b;
	Pair(int score, int b) {
		this.score = score;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.b > this.b) return 1;
		else if(o.b == this.b) return Integer.compare(this.score, o.score);
		else return -1;
	}
}