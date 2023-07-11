import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, X, Y;
	static int[] arr, chk;
	static ArrayList<Integer>[] aly;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		arr = new int[N];
		chk = new int[N];
		aly = new ArrayList[N];
		q = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			chk[i] = 1000000000;
			aly[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			aly[a].add(b);
			aly[b].add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Y; i++) {
			int num = Integer.parseInt(st.nextToken()) - 1;
			q.offer(num);
			chk[num] = 0;
		}
		
		bfs();
		
		long res = 0l;
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			if(chk[i] == 0) continue;
			if(chk[i] == 1000000000 && arr[i] > 0) {
				bw.write("-1");
				bw.flush();
				return;
			}
			pq.offer((long)arr[i] * (long)chk[i]);
		}
		
		while(!pq.isEmpty() && --X >= 0) res += pq.poll();
		
		bw.write(res+"");
		bw.flush();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int next : aly[x])
				if(chk[next] > chk[x] + 1) {
					chk[next] = chk[x] + 1;
					q.offer(next);
				}
		}
	}
}