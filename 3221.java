import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			if(c == 'D') {
				int time = T + x;
				if(time < L) pq.offer(time);
				else pq.offer(time / L % 2 == 0 ? time % L : L - time % L);
			}
			else {
				int time = T + L - x;
				if(time < L) pq.offer(L - time);
				else pq.offer(time / L % 2 == 0 ? L - time % L : time % L);
			}
		}
		
		while(!pq.isEmpty()) bw.write(pq.poll() + " ");
		bw.flush();
	}
}