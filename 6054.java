import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N + 1];
		ArrayList<Integer>[] aly = new ArrayList[N + 1];
		HashSet<Integer> hs = new HashSet<>();
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			aly[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			while(--num >= 0) aly[i].add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		hs.add(1);
		int t;
		for(t = 0;; t++) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				time[x] -= 1;
				if(time[x] == 0) {
					for(int k : aly[x])
						if(!hs.contains(k)) {
							q.offer(k);
							hs.add(k);
						}
					continue;
				}
				else q.offer(x);
			}
			
			if(hs.size() == N && q.isEmpty()) break;
		}
		
		System.out.println(t + 1);
	}
}