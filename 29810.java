import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, K, res, tmp, m;
	static boolean flag;
	static ArrayList<Integer>[] aly;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		aly = new ArrayList[N + 1];
		chk = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			aly[a].add(b);
			aly[b].add(a);
		}
		
		K = Integer.parseInt(br.readLine());
		res = 0;
		
		chk[K] = true;
		for(int next : aly[K]) {
			m = 0;
			tmp = 1;
			flag = false;
			solve(next, 0, K);
			
			res = Math.max(res, tmp - m);
		}
		
		for(int i = 1; i <= N; i++)
			if(!chk[i]) {
				tmp = 0;
				solve(i, 0, 0);
				res = Math.max(res, tmp);
			}
		
		bw.write(res+"");
		bw.flush();
	}
	private static void solve(int idx, int p1, int p2) {
		if(idx == K && p1 != K && !flag) {
			m = 1;
			flag = true;
		}
		if(chk[idx]) return;
		chk[idx] = true;	
		tmp += 1;
		
		for(int next : aly[idx]) solve(next, p2, idx);
	}
}