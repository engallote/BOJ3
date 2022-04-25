import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		while(--T >= 0) {
			int N = Integer.parseInt(br.readLine());
			Pair[] arr = new Pair[N];
			ArrayList<Integer>[] aly = new ArrayList[100001];
			
			for(int i = 0; i <= 100000; i++) aly[i] = new ArrayList<>();
			
			StringTokenizer st;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				aly[x].add(y);
			}
			
			int idx = 0, y = 0;
			for(int i = 0; i <= 100000; i++) {
				if(aly[i].isEmpty()) continue;
				Collections.sort(aly[i]);
				if(aly[i].get(0) == y) {
					for(int j = 0; j < aly[i].size(); j++) {
						arr[idx++] = new Pair(i, aly[i].get(j));
						y = aly[i].get(j);
					}
				}
				else {
					for(int j = aly[i].size() - 1; j >= 0; j--) {
						arr[idx++] = new Pair(i, aly[i].get(j));
						y = aly[i].get(j);
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			while(--M >= 0) {
				int num = Integer.parseInt(st.nextToken());
				bw.write(arr[num - 1].x + " " + arr[num - 1].y + "\n");
			}
		}
		bw.flush();
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}