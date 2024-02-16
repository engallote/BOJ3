import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static long res, cnt;
	static ArrayList<Integer>[] aly;
	static long[] chk, dep;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		aly = new ArrayList[N + 1];
		chk = new long[N + 1];
		dep = new long[N + 1];
		
		for(int i = 1; i <= N; i++) {
			aly[i] = new ArrayList<>();
			chk[i] = -1;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			aly[(int)a].add(b);
			aly[(int)b].add(a);
		}
		
		for(int i = 1; i <= N; i++) Collections.sort(aly[i]);
		
		res = 0;
		cnt = 2;
		chk[R] = 1;
		dep[R] = 0;
		solve(R, 1);
		
		for(int i = 1; i <= N; i++) res += chk[i] * (long)dep[i];
		
		bw.write(res + "");
		bw.flush();
	}
	private static void solve(int r, int d) {		
		for(int i = 0; i < aly[r].size(); i++) {
			int next = aly[r].get(i);
			
			if(chk[next] != -1) continue;
			chk[next] = cnt++;
			dep[next] = d; 
			solve(next, d + 1);
		}
	}
}