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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> ans = new LinkedList<>();
		for(int i = 0; i < N; i++) pq.offer(Integer.parseInt(br.readLine()));
		
		int Y = 0;
		while(!pq.isEmpty()) {
			int x = pq.poll();
			
			if(x <= K) continue;
			
			Y = (Y / 2) + x;
			ans.offer(Y);
			
			if(x - M <= K) continue;
			pq.offer(x - M);
		}
		
		bw.write(ans.size() + "\n");
		while(!ans.isEmpty()) bw.write(ans.poll() + "\n");
		bw.flush();
	}
}