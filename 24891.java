import java.util.*;

public class Main {
	static int L, N;
	static String[] arr;
	static char[][] ch;
	static boolean[] chk;
	static PriorityQueue<String> pq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		N = sc.nextInt();
		ch = new char[L][L];
		arr = new String[N];
		chk = new boolean[N];
		pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) arr[i] = sc.next();
		
		solve(0);
		
		if(!pq.isEmpty()) System.out.println(pq.poll());
		else System.out.println("NONE");
	}
	private static void solve(int idx) {
		if(idx == L) {
			StringBuilder sb = new StringBuilder();
			
			int r = 0, c = 0;
			while(r < L) {
				sb = new StringBuilder();
				for(int i = 0; i < L; i++) sb.append(ch[i][c]);
				
				if(!new String(ch[r]).equals(sb.toString())) return;
				
				++r;
				++c;
			}
			
			sb = new StringBuilder();
			for(int i = 0; i < L; i++) sb.append(new String(ch[i]) + "\n");
			pq.offer(sb.toString());
			return;
		}
		
		for(int i = 0; i < N; i++)
			if(!chk[i]) {
				chk[i] = true;
				ch[idx] = arr[i].toCharArray();
				
				solve(idx + 1);
				
				chk[i] = false;
			}
	}
}