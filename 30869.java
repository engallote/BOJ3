import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] arr;
	static int[][] chk;
	static ArrayList<Integer>[] aly;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[M][4];
		aly = new ArrayList[N + 1];
		chk = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			aly[i] = new ArrayList<>();
			Arrays.fill(chk[i], Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());//s에서 e까지 걸리는 시간
			int g = Integer.parseInt(st.nextToken());//배차간격
			
			arr[i][0] = s;
			arr[i][1] = e;
			arr[i][2] = t;
			arr[i][3] = g;
			
			aly[s].add(i);
		}
		
		bw.write(bfs()+"");
		bw.flush();
	}
	private static int bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0, K));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.s == N) return p.time;
			
			for(int i = 0; i < aly[p.s].size(); i++) {
				int idx = aly[p.s].get(i);
				int wait_time = p.time % arr[idx][3];
				
				if(wait_time != 0) wait_time = arr[idx][3] - wait_time;
				
				if(chk[p.s][arr[idx][1]] > p.time + arr[idx][2] + wait_time) {
					chk[p.s][arr[idx][1]] = p.time + arr[idx][2] + wait_time;
					pq.offer(new Pair(arr[idx][1], p.time + arr[idx][2] + wait_time, p.k));
				}
				
				//배차시간 때문에 기다리는 시간이 발생하는 경우
				if(wait_time != 0 && p.k > 0) {
					if(chk[p.s][arr[idx][1]] > p.time + arr[idx][2]) {
						chk[p.s][arr[idx][1]] = p.time + arr[idx][2];
						pq.offer(new Pair(arr[idx][1], p.time + arr[idx][2], p.k - 1));
					}
				}
			}
		}
		
		return -1;
	}
}
class Pair implements Comparable<Pair> {
	int s, time, k;
	Pair(int s, int time, int k) {
		this.s = s;
		this.time = time;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.time < o.time) return -1;
		else if(this.time == o.time) return Integer.compare(o.s, this.s);
		else return 1;
	}
}