import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while(--T >= 0) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for(int i = 0; i < N; i++) pq.offer(Long.parseLong(st.nextToken()));
			
            if(N == 1) {
				bw.write(1 + "\n");
				continue;
			}
            
			long res = 1;
			while(pq.size() > 1) {
				long a = pq.poll();
				long b = pq.poll();
				
				pq.offer(a * b);
				res *= (a * b) % 1000000007;
				res %= 1000000007;
			}
			
			bw.write(res + "\n");
		}
		bw.flush();
	}
}