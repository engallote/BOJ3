import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++) {
    		String a = sc.next();
    		String b = sc.next();
    		pq.offer(new Pair(a, b));
    	}
    	
    	while(!pq.isEmpty()) System.out.println(pq.peek().a + " " + pq.poll().b);
	}
}
class Pair implements Comparable<Pair> {
	String a, b;
	Pair(String a, String b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		char[] a1 = this.a.toCharArray(), a2 = o.a.toCharArray();
		
		for(int i = 0; i < Math.min(a1.length, a2.length); i++) {
			if(a1[i] > a2[i]) return 1;
			else if(a1[i] < a2[i]) return -1;
		}
		
		if(a1.length > a2.length) return 1;
		else if(a1.length < a2.length) return -1;
		
		char[] b1 = this.b.toCharArray(), b2 = o.b.toCharArray();
		for(int i = 0; i < Math.min(b1.length, b2.length); i++) {
			if(b1[i] > b2[i]) return -1;
			else if(b1[i] < b2[i]) return 1;
		}
		
		if(b1.length > b2.length) return -1;
		else if(b1.length < b2.length) return 1;
		else return 0;
	}
	
}