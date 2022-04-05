import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, R, giga;
	static boolean[] chk;
	static ArrayList<Pair>[] aly;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		aly = new ArrayList[N + 1];
		chk = new boolean[N + 1];
		giga = 0;
		
		if(N == 1) {
			System.out.println("0 0");
			return;
		}
		
		for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			aly[a].add(new Pair(b, c));
			aly[b].add(new Pair(a, c));
		}
		
		int res1 = cal(R, 0);
		int res2 = find(giga, 0);
		
		bw.write(res1 + " " + res2);
		bw.flush();
	}
	private static int find(int x, int sum) {
		chk[x] = true;
		if(aly[x].size() == 1) return sum;
		int ret = 0;
		
		for(Pair next : aly[x]) {
			if(chk[next.v]) continue;
			ret = Math.max(ret, find(next.v, sum + next.cost));
		}
		
		return ret;
	}
	private static int cal(int x, int sum) {
		chk[x] = true;
		giga = x;
		if(aly[x].size() > 2 || aly[R].size() == 2) return sum;
		
		for(Pair next : aly[x]) {
			if(chk[next.v]) continue;
			return cal(next.v, sum + next.cost);
		}
		
		return sum;
	}
}
class Pair {
	int v, cost;
	Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}