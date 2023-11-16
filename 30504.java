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
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N], res = new int[N];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			pq.offer(new Pair(i, num));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			Pair p = pq.poll();
			
			if(p.num > arr[i]) {
				System.out.println(-1);
				return;
			}
			res[p.idx] = arr[i];
		}
		
		for(int i = 0; i < N; i++) bw.write(res[i] + " ");
		bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int idx, num;
	Pair(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.num, o.num);
	}
}