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
		int K = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		long[] sum = new long[N];
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if(i == 0) sum[i] = arr[i];
			else sum[i] = sum[i - 1] + arr[i];
			
			pq.offer(new Pair(sum[i], i));
		}
		
		PriorityQueue<Integer> order = new PriorityQueue<>();
		for(int i = 0; i < K; i++) order.offer(pq.poll().idx);
		
		long res = 0;
		int pre = -1;
		while(!order.isEmpty()) {
			int idx = order.poll();
			
			res += (sum[idx] - (pre != -1 ? sum[pre] : 0)) * K;
			
			K -= 1;
			pre = idx;
		}
		
		bw.write(res+"");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	long num;
	int idx;
	Pair(long num, int idx) {
		this.num = num;
		this.idx = idx;
	}
	@Override
	public int compareTo(Pair o) {
		return Long.compare(o.num, this.num);
	}
}