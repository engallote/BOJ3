import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, cnt;
	static ArrayList<Integer>[] aly;
	static int[] chk;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		aly = new ArrayList[N + 1];
		chk = new int[N + 1];
		
		for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			aly[a].add(b);
			aly[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) Collections.sort(aly[i]);
		
		chk[R] = 1;
		cnt = 2;
		solve(R);
		
		for(int i = 1; i <= N; i++) bw.write(chk[i] + "\n");
		bw.flush();
	}
	private static void solve(int r) {
		for(int i = aly[r].size() - 1; i >= 0; i--) {
			int next = aly[r].get(i);
			
			if(chk[next] != 0) continue;
			chk[next] = cnt++;
			solve(next);
		}
	}
}