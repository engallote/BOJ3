import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger s = new BigInteger(sc.next());
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) pq.offer(new Pair(sc.next(), new BigInteger(sc.next())));
		
		int res = 0;
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(s.compareTo(p.num) >= 0) {
				s = s.subtract(p.num);
				++res;
				sb.append(p.name + "\n");
			}
		}
		
		if(s.compareTo(BigInteger.ZERO) == 0) {
			System.out.println(res);
			System.out.println(sb.toString());
		}
		else System.out.println(0);
	}
}
class Pair implements Comparable<Pair> {
	BigInteger num;
	String name;
	Pair(String name, BigInteger num) {
		this.name = name;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.num.compareTo(o.num) == 1) return -1;
		else if(this.num.compareTo(o.num) == 0) return 0;
		else return 1;
	}
}