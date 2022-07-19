import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		if(N == K) {
			int sum = 0;
			for(int i = 0; i < N; i++) sum += sc.nextInt();
			System.out.println(sum);
			return;
		}
		
		int[] arr = new int[N];
		Queue<Integer> q = new LinkedList<>();
		int sum = 0, max = -1;
		
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		for(int i = 0; i < N + K; i++) {
			if(q.size() == K) {
				sum -= q.poll();
				q.offer(arr[i % N]);
				sum += arr[i % N];
				
				max = Math.max(max, sum);
			}
			else {
				q.offer(arr[i % N]);
				sum += arr[i % N];
			}
		}
		
		System.out.println(max);
	}
}