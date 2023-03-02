import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int[] score = {10, 8, 6, 5, 4, 3, 2, 1, 0};
		
		for(int i = 0; i < 8; i++) {
			String[] time = sc.next().split(":");
			char team = sc.next().charAt(0);
			
			int h = Integer.parseInt(time[0]);
			int m = Integer.parseInt(time[1]);
			int s = Integer.parseInt(time[2]);
			
			pq.offer(new Pair(h, m, s, team));
		}
		
		int b = 0, r = 0, idx = 0;
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.team == 'R') r += score[idx];
			else b += score[idx];
			
			idx += 1;
		}
		
		System.out.println(r < b ? "Blue" : "Red");
	}
}
class Pair implements Comparable<Pair> {
	int h, m, s;
	char team;
	Pair(int h, int m, int s, char team) {
		this.h = h;
		this.m = m;
		this.s = s;
		this.team = team;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.h < o.h) return -1;
		else if(this.h == o.h) {
			if(this.m < o.m) return -1;
			else if(this.m == o.m) return Integer.compare(this.s, o.s);
			else return 1;
		}
		else return 1;
	}
}