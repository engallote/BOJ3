import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Queue<Pair> q = new LinkedList<>();
		HashSet<Integer> hs = new HashSet<>();
		StringBuilder sb;
		
		while(--T >= 0) {
			sb = new StringBuilder();
			q.clear();
			hs.clear();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a % b == 0) {
				System.out.println(a/b + ".(0)");
				continue;
			}
			
			boolean first = false;
			while(true) {
				q.offer(new Pair(a, a / b));
				a -= a / b * b;
				a *= 10;
				
				if(hs.contains(a)) {
					while(!q.isEmpty()) {
						Pair p = q.poll();
						
						if(p.a == a) sb.append("(" + p.b);
						else sb.append(p.b);
						if(!first) {
							sb.append(".");
							first = true;
						}
					}
					break;
				}
				if(a == 0) {
					while(!q.isEmpty()) {
						Pair p = q.poll();
						sb.append(p.b);
						if(!first) {
							sb.append(".");
							first = true;
						}
					}
					sb.append("(0");
					break;
				}
				
				hs.add(a);
			}
			sb.append(")");
			System.out.println(sb.toString());
		}
	}
}
class Pair {
	int a, b;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}