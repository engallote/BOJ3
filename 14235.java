import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if(num == 0) {
				if(pq.isEmpty()) System.out.println(-1);
				else System.out.println(pq.poll());
			}
			else for(int j = 0; j < num; j++) pq.offer(sc.nextInt());
		}
	}
}