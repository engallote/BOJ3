import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + M + 1];
		TreeSet<Pair> t1 = new TreeSet<>(), t2 = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			t1.add(new Pair(i, arr[i]));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = N + 1; i <= N + M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			t2.add(new Pair(i, arr[i]));
		}
		
		int K = Integer.parseInt(br.readLine());
		int a = 0, b = 0;
		while(--K >= 0) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			
			if(c == 'U') {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				
				if(x <= N) {
					Pair p = new Pair(x, arr[x]);
					t1.remove(p);
					
					arr[x] = y;
					
					t1.add(new Pair(x, y));
				}
				else {
					Pair p = new Pair(x, arr[x]);
					t2.remove(p);
					
					arr[x] = y;
					
					t2.add(new Pair(x, y));
				}
				
			}
			else {
				a = t1.first().idx;
				b = t2.first().idx;
				bw.write(a + " " + b + "\n");
			}			
		}
		
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
		if(this.num < o.num) return -1;
		else if(this.num == o.num) return Integer.compare(this.idx, o.idx);
		else return 1;
	}
}