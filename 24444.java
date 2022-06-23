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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] aly = new ArrayList[N + 1];
		int[] res = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			aly[i] = new ArrayList<>();
			res[i] = -1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(R);
		
		while(--M >= 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			aly[x].add(y);
			aly[y].add(x);
		}
		
		for(int i = 1; i <= N; i++) if(!aly[i].isEmpty()) Collections.sort(aly[i]);
		
		for(int i = 1; !q.isEmpty();) {
			int x = q.poll();
			if(res[x] == -1) {
				res[x] = i;
				i++;
			}
			else continue;
			for(int next : aly[x])
				if(res[next] == -1)	q.offer(next);
		}
		
		for(int i = 1; i <= N; i++)
			bw.write((res[i] == -1 ? 0 : res[i]) + "\n");
		bw.flush();
	}
}