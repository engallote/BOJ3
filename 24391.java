import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		par = new int[N + 1];
		
		for(int i = 0; i <= N; i++) par[i] = i;
		
		while(--M >= 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int ap = find(a), bp = find(b);
			if(ap == bp) continue;
			
			if(bp < ap) {
				int tmp = ap;
				ap = bp;
				bp = tmp;
			}
			par[bp] = ap;
		}
		
		st = new StringTokenizer(br.readLine());
		int res = 0, pre = find(Integer.parseInt(st.nextToken()));
		for(int i = 1; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int tmp = find(num);
			
			if(pre != tmp) ++res;
			
			pre = tmp;
		}
		
		bw.write(res+"");
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}