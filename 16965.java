import java.util.*;

public class Main {
	static boolean[] chk;
	static ArrayList<Pair> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		while(--N >= 0) {
			int num = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(num == 1) aly.add(new Pair(a, b));
			else System.out.println(bfs(a - 1, b - 1));
		}
	}

	private static int bfs(int a, int b) {
		chk = new boolean[201];
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		chk[a] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				if(x == b) return 1;
				
				for(int i = 0; i < aly.size(); i++) {
					if(chk[i]) continue;
					if((aly.get(i).a < aly.get(x).a && aly.get(x).a < aly.get(i).b) || (aly.get(i).a < aly.get(x).b && aly.get(x).b < aly.get(i).b)) {
						chk[i] = true;
						q.offer(i);
					}
				}
			}
		}
		
		return 0;
	}
}
class Pair {
	int a, b;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}