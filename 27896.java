import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int res = 0;
		long sum = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			pq.offer(num);
			
			sum += num;
			if(sum >= M) {
				sum -= pq.poll() * 2;
				++res;
			}
		}
		
		System.out.println(res);
	}
}