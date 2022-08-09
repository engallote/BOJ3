import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt() - 1;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) pq.offer(sc.nextInt());
		
		while(--K >= 0) pq.poll();
		
		System.out.println(pq.peek());
	}
}