import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if(num % 2 == 0) sum += num;
			else pq.offer(num);
		}
		
		if(pq.size() >= 2) {
			while(pq.size() > 1) {
				int a = pq.poll();
				int b = pq.poll();
				
				sum += a + b;
			}
		}
		
		System.out.println(sum);
	}
}