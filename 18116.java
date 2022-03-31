import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		par = new int[1000001];
		int[] cnt = new int[1000001];
		
		for(int i = 0; i <= 1000000; i++) {
			par[i] = i;
			cnt[i] = 1;
		}
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			
			if(c.equals("I")) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(a > b) {
					int tmp = a;
					a = b;
					b = tmp;
				}
				int ap = find(a), bp = find(b);
				
				if(ap == bp) continue;
				par[bp] = ap;
				cnt[ap] += cnt[bp];
			}
			else {
				int num = Integer.parseInt(st.nextToken());
				sb.append(cnt[find(num)] + "\n");
			}
		}
		System.out.println(sb);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}