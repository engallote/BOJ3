import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt() - 1;
		int B = sc.nextInt() - 1;
		
		ArrayList<Pair> aly = new ArrayList<>();
		for(int i = 0; i < N; i++) aly.add(new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		
		int res = 0, max, min;
		for(int i = 0; i < N; i++) {
			int sx = aly.get(i).x, sy = aly.get(i).y, w = aly.get(i).w;
			int ex = sx + A, ey = sy + B;
			
			max = w;
			min = w;
			for(Pair p : aly)
				if(sx <= p.x && p.x <= ex && sy <= p.y && p.y <= ey) {
					max = Math.max(max, p.w);
					min = Math.min(min, p.w);
				}
			
			res = Math.max(res, max - min);
			max = w;
			min = w;
			for(Pair p : aly) {
				ey = sy - B;
				if(sx <= p.x && p.x <= ex && ey <= p.y && p.y <= sy) {
					max = Math.max(max, p.w);
					min = Math.min(min, p.w);
				}
			}
			
			res = Math.max(res, max - min);
			max = w;
			min = w;
			for(Pair p : aly) {
				ex = sx - A;
				ey = sy + B;
				if(ex <= p.x && p.x <= sx && sy <= p.y && p.y <= ey) {
					max = Math.max(max, p.w);
					min = Math.min(min, p.w);
				}
			}
			
			res = Math.max(res, max - min);
			max = w;
			min = w;
			for(Pair p : aly) {
				ey = sy - B;
				if(ex <= p.x && p.x <= sx && ey <= p.y && p.y <= sy) {
					max = Math.max(max, p.w);
					min = Math.min(min, p.w);
				}
			}
			
			res = Math.max(res, max - min);
		}
		
		System.out.println(res);
	}
}
class Pair {
	int x, y, w;
	Pair(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}
}