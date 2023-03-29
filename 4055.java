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
		
		for(int t = 1;; t++) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			ArrayList<Pair> aly = new ArrayList<>();
			StringTokenizer st;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				aly.add(new Pair(a, b));
			}
			
			Collections.sort(aly);
			
			boolean[] chk = new boolean[N];
			int cnt = 0, res = 0;
			for(int time = 8; time <= 23; time++) {
				cnt = 0;
				for(int i = 0; i < aly.size(); i++) {
					if(chk[i]) continue;
					
					Pair p = aly.get(i);
					if(p.s == p.e) continue;
					
					if(p.s <= time && time < p.e) {
						chk[i] = true;
						++res;
						++cnt;
					}
					
					if(cnt == 2) break;
				}
			}
			
			bw.write("On day " + t + " Emma can attend as many as " + res + " parties.\n");
		}
		bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int s, e;
	Pair(int s, int e) {
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.e < o.e) return -1;
		else if(this.e == o.e) return Integer.compare(o.s, this.s);
		else return 1;
	}
}