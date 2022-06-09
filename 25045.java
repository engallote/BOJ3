import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq1 = new PriorityQueue<>(Collections.reverseOrder()), pq2 = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) pq1.offer(Long.parseLong(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) pq2.offer(Long.parseLong(st.nextToken()));
		
		long res = 0;
		while(!pq1.isEmpty() && !pq2.isEmpty()) {
			long a = pq1.poll();
			long b = pq2.poll();
			
			if(a < b) break;
			
			res += a - b;
		}
		
		System.out.println(res);
	}
}