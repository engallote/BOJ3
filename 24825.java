import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			long d = Integer.parseInt(st.nextToken());
			pq.offer(new Pair(a, d));
		}
		
		for(int i = 0; i < h; i++) {
			Pair p = pq.poll();
			
			pq.offer(new Pair(p.a + p.d, p.d));
		}
		
		long max = 0;
		while(!pq.isEmpty()) max = Math.max(max, pq.poll().a);
		
		bw.write(max+"");
		bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	long a, d;
	Pair(long a, long d) {
		this.a = a;
		this.d = d;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.a + o.d > this.a + this.d) return -1;
		else if(o.a + o.d == this.a + this.d) return 0;
		else return 1;
	}
}