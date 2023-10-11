import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		
		if(S == 0) {
			System.out.println(1);
			System.out.println(0 + " " + 0);
			return;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();		
		long num1 = 0l, num2 = 0l;
		for(long g = 0; g <= 200; g++)
			for(long e = 0; e <= 200; e++) {
				num1 = g * 508l;
				num2 = e * 212l;
				if((num1 + num2) * 4763l == S) pq.offer(new Pair(g, e));
				
				num1 = g * 508l;
				num2 = e * 305l;
				if((num1 + num2) * 4763l == S) pq.offer(new Pair(g, e));
				
				num1 = g * 108l;
				num2 = e * 305l;
				if((num1 + num2) * 4763l == S) pq.offer(new Pair(g, e));
				
				num1 = g * 108l;
				num2 = e * 212l;
				if((num1 + num2) * 4763l == S) pq.offer(new Pair(g, e));
			}
		
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size() + "\n");
		while(!pq.isEmpty()) sb.append(pq.peek().a + " " + pq.poll().b + "\n");
		System.out.println(sb.toString());
	}
}
class Pair implements Comparable<Pair> {
	long a, b;
	Pair(long a, long b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.a < o.a) return -1;
		else if(this.a == o.a) {
			if(this.b < o.b) return -1;
			else if(this.b == o.b) return 0;
			else return 1;
		}
		else return 1;
	}
}