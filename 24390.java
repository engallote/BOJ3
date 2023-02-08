import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String[] str = sc.next().split(":");
    	int m = Integer.parseInt(str[0]), s = Integer.parseInt(str[1]);
    	int needS = m * 60 + s;
    	
    	if(needS == 0) {
    		System.out.println(0);
    		return;
    	}
    	if(needS == 30) {
    		System.out.println(1);
    		return;
    	}
    	
    	int[][] chk = new int[100000][2];
    	for(int i = 0; i < 100000; i++) Arrays.fill(chk[i], Integer.MAX_VALUE);
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	pq.offer(new Pair(0, 0, 0));
    	
    	int res = Integer.MAX_VALUE;
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		
			if(p.s == needS) {
				if(p.f == 1) res = Math.min(res, p.cnt);
				else res = Math.min(res, p.cnt + 1);
				continue;
			}
			
			if(p.s == 0 && p.f == 0) {
				if(p.s + 30 <= needS && chk[p.s + 30][1] > p.cnt + 1) {
					chk[p.s + 30][1] = p.cnt + 1;
					pq.offer(new Pair(p.s + 30, p.cnt + 1, 1));
				}
			}
			if(p.s + 10 <= needS && chk[p.s + 10][p.f] > p.cnt + 1) {
				chk[p.s + 10][p.f] = p.cnt + 1;
				pq.offer(new Pair(p.s + 10, p.cnt + 1, p.f));
			}
			if(p.s + 30 <= needS && chk[p.s + 30][p.f] > p.cnt + 1) {
				chk[p.s + 30][p.f] = p.cnt + 1;
				pq.offer(new Pair(p.s + 30, p.cnt + 1, 1));
			}
			if(p.s + 60 <= needS && chk[p.s + 60][p.f] > p.cnt + 1) {
				chk[p.s + 60][p.f] = p.cnt + 1;
				pq.offer(new Pair(p.s + 60, p.cnt + 1, p.f));
			}
			if(p.s + 600 <= needS && chk[p.s + 600][p.f] > p.cnt + 1) {
				chk[p.s + 600][p.f] = p.cnt + 1;
				pq.offer(new Pair(p.s + 600, p.cnt + 1, p.f));
			}
    	}
    	
    	System.out.println(res);
	}
}
class Pair implements Comparable<Pair> {
	int s, cnt, f;
	Pair(int s, int cnt, int f) {
		this.s = s;
		this.cnt = cnt;
		this.f = f;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cnt, o.cnt);
	}
}