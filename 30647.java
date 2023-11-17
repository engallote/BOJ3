import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			String[] arr = sc.next().split(":");
			
			//find name
			String[] sp = arr[1].split(",");
			String name = sp[0].substring(1, sp[0].length() - 1);
			
			//find score
			sp = arr[2].split(",");
			int score = Integer.parseInt(sp[0]);
			
			//find hidden
			int h = arr[3].charAt(0) - '0';
			
			pq.offer(new Pair(name, score, h));
		}
		
		int rate = 1, jump = 0, pre = 0;
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(pre != p.score) {
				rate += jump;
				jump = 0;
			}
			if(p.h == 0) System.out.println(rate + " " + p.name + " " + p.score);
			pre = p.score;
			jump += 1;
		}
	}
}
class Pair implements Comparable<Pair> {
	String name;
	int score, h;
	Pair(String name, int score, int h) {
		this.name = name;
		this.score = score;
		this.h = h;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.score > o.score) return -1;
		else if(this.score == o.score) {
			char[] a = this.name.toCharArray(), b = o.name.toCharArray();
			for(int i = 0; i < Math.min(a.length, b.length); i++) {
				if(a[i] > b[i]) return 1;
				else if(a[i] < b[i]) return -1;
			}
			
			if(a.length > b.length) return 1;
			else if(a.length == b.length) return 0;
			else return -1;
		}
		else return 1;
	}
}