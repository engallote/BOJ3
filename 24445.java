import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static PriorityQueue<Integer>[] pq;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[] chk = new int[N + 1];
		pq = new PriorityQueue[N + 1];
		
		for(int i = 1; i <= N; i++) pq[i] = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			pq[a].offer(b);
			pq[b].offer(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(R);
		chk[R] = 1;
		
		int size = 0, cnt = 2;
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				while(!pq[x].isEmpty()) {
					int p = pq[x].poll();
					
					if(chk[p] == 0) {
						chk[p] = cnt++;
						q.offer(p);
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) bw.write(chk[i] + "\n");
		bw.flush();
	}
}