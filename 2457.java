import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] arr = new Pair[N];
		
		for(int i = 0; i < N; i++) {
			int ss = sc.nextInt();
			int se = sc.nextInt();
			int es = sc.nextInt();
			int ee = sc.nextInt();
			
			arr[i] = new Pair(ss * 1000 + se, es * 1000 + ee);
		}
		
		Arrays.sort(arr);
		
		if(arr[0].s > 3001) {
			System.out.println(0);
			return;
		}
		
		int idx = 0, res = 0;
		int pre = 3001, max = 0;
		while(true) {
			for(int i = idx; i < N; i++) {
				if(arr[i].s > pre) break;
				if(arr[i].e > max) {
					max = arr[i].e;
					idx = i;
				}
			}
			
			if(max == pre) {
				System.out.println(0);
				return;
			}
			pre = max;
			++res;
			
			if(pre > 11030) break;
		}
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair> {
	int s, e;
	Pair(int s, int e) {
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return -1;
		else if(o.s == this.s) return Integer.compare(this.e, o.e);
		else return 1;
	}
}