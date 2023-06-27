import java.util.*;

public class Main {
	static int res = 0;
	static Queue<Pair> q = new LinkedList<>();
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int N = sc.nextInt();
		int M = sc.nextInt();
		chk = new boolean[10000][10000];
		
		for(int i = 0; i < N; i++) {
			char[] ch = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				if(ch[j] == 'o') {
					q.offer(new Pair(i + 5000, j + 5000));
					chk[i + 5000][j + 5000] = true;
				}
		}
		
		int K = sc.nextInt();
		
		if(q.isEmpty()) {
			System.out.println(0);
			return;
		}
		
		bfs(K);
		
		System.out.println(res);
	}
	private static void bfs(int k) {
		while(--k >= 0) {			
			//살아있는 애 기준으로 넓히기
			res += q.size();
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				if(!chk[p.x - 1][p.y]) {
					q.offer(new Pair(p.x - 1, p.y));
					chk[p.x - 1][p.y] = true;
				}
				if(!chk[p.x + 1][p.y]) {
					q.offer(new Pair(p.x + 1, p.y));
					chk[p.x + 1][p.y] = true;
				}
				if(!chk[p.x][p.y - 1]) {
					q.offer(new Pair(p.x, p.y - 1));
					chk[p.x][p.y - 1] = true;
				}
				if(!chk[p.x][p.y + 1]) {
					q.offer(new Pair(p.x, p.y + 1));
					chk[p.x][p.y + 1] = true;
				}
			}
		}
		
		res += q.size();
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}