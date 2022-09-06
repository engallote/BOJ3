import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static boolean[] chk;
	static char[] ch;
	static ArrayList<Integer>[] aly;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ch = br.readLine().trim().toCharArray();
		aly = new ArrayList[N];
		chk = new boolean[N];
		
		for(int i = 0; i < N; i++) aly[i] = new ArrayList<>();
		
		StringTokenizer st;
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			aly[a].add(b);
			aly[b].add(a);
		}
		
		bfs();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>(), q2 = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		q.offer(0);
		chk[0] = true;
		sb.append(ch[0]);
		
		while(!q.isEmpty()) {
			char pre = 'a';
			q2.clear();
			
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				for(int next : aly[x]) 
					if(!chk[next]) {					
						if(pre == ch[next]) q2.offer(next);
						else if(pre < ch[next]) {
							q2.clear();
							q2.offer(next);
							pre = ch[next];
						}
					}
			}
			
			if(q2.isEmpty()) {
				System.out.println(sb.toString());
				return;
			}
			
			sb.append(pre);
			while(!q2.isEmpty()) {
				chk[q2.peek()] = true;
				q.offer(q2.poll());
			}
		}
	}
}