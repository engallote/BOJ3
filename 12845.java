import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) pq.offer(sc.nextInt());
		
		int res = 0;
		while(pq.size() > 1) {
			int a = pq.poll(), b = pq.poll();
			res += a + b;
			pq.offer(Math.max(a, b));
		}
		
		System.out.println(res);
	}
}