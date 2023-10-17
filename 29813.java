import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			String name = sc.next();
			int num = sc.nextInt();
			
			q.offer(new Pair(name, num));
		}
		
		while(q.size() > 1) {
			Pair p = q.poll();
			
			for(int i = 1; i < p.num; i++) {
				Pair nxt = q.poll();
				q.offer(nxt);
			}
			
			q.poll();
		}
		
		System.out.println(q.poll().name);
	}
}
class Pair {
	String name;
	int num;
	Pair(String name, int num) {
		this.name = name;
		this.num = num;
	}
}