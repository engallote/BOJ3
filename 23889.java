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
    	int[] arr = new int[N + 1], rock = new int[K];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < K; i++) rock[i] = Integer.parseInt(st.nextToken());
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	int sum = 0;
    	for(int i = 0; i < K - 1; i++) {
    		sum = 0;
    		for(int j = rock[i]; j < rock[i + 1]; j++) sum += arr[j];
    		
    		pq.offer(new Pair(rock[i], sum));
    	}
    	sum = 0;
    	for(int j = rock[K - 1]; j <= N; j++) sum += arr[j];
    	pq.offer(new Pair(rock[K - 1], sum));
    	
    	PriorityQueue<Integer> res = new PriorityQueue<>();
    	while(!pq.isEmpty() && --M >= 0) {
    		Pair p = pq.poll();
    		res.offer(p.idx);
    	}
    	
    	while(!res.isEmpty()) bw.write(res.poll() + "\n");
    	bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int idx, cnt;
	Pair(int idx, int cnt) {
		this.idx = idx;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.cnt > o.cnt) return -1;
		else if(this.cnt == o.cnt) return Integer.compare(this.idx, o.idx);
		else return 1;
	}
}