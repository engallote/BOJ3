import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int P = sc.nextInt();
		boolean[][][] arr = new boolean[N + 1][22][60];
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < T; i++) {
			String s = sc.next();
			String e = sc.next();
			
			int sh = Integer.parseInt(s.substring(0, 2));
			int sm = Integer.parseInt(s.substring(2));
			int eh = Integer.parseInt(e.substring(0, 2));
			int em = Integer.parseInt(e.substring(2));
			
			pq.offer(new Pair(i + 1, sh, sm, eh, em));
		}
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			int min = Integer.MAX_VALUE, max = 0, idx = 1;
			
			for(int k = 1; k <= N; k++) {//ÁÂ¼® ¹øÈ£
				if(!arr[k][p.sh][p.sm]) {//ÁÂ¼® ºñ¾ú´Ù
					min = 10000000;
					for(int i = 1; i <= N; i++) {
						if(k == i) continue;
						if(arr[i][p.sh][p.sm]) {
							int dist = Math.abs(i - k);
							if(dist < min) min = dist;
						}
					}
					
					if(min > max) {
						max = min;
						idx = k;
					}
				}
			}//for k
			
			if(p.sh == p.eh) {
				for(int i = p.sm; i < p.em; i++)
					arr[idx][p.sh][i] = true;
			}
			else {
				for(int i = p.sh; i <= p.eh; i++) {
					if(i == p.sh) for(int j = p.sm; j < 60; j++) arr[idx][i][j] = true;
					else if(i == p.eh) for(int j = 0; j < p.em; j++) arr[idx][i][j] = true;
					else for(int j = 0; j < 60; j++) arr[idx][i][j] = true;
				}
			}
		}
		
		int res = 0;
		for(int i = 9; i <= 20; i++)
			for(int j = 0; j < 60; j++)
				if(!arr[P][i][j]) ++res;
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair> {
	int idx, sh, sm, eh, em;
	Pair(int idx, int sh, int sm, int eh, int em) {
		this.idx = idx;
		this.sh = sh;
		this.sm = sm;
		this.eh = eh;
		this.em = em;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.sh < o.sh) return -1;
		else if(this.sh == o.sh) {
			if(this.sm < o.sm) return -1;
			else if(this.sm == o.sm) {
				if(this.eh < o.eh) return -1;
				else if(this.eh == o.eh) return Integer.compare(this.em, o.em);
				else return 1;
			}
			else return 1;
		}
		else return 1;
	}
}