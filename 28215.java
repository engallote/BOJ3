import java.util.*;

public class Main {
	static int N, K, res;
	static Pair[] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new Pair[N];
		chk = new boolean[N];
		res = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		
		ArrayList<Integer> path = new ArrayList<>();
		solve(0, 0, path);
		
		System.out.println(res);
	}
	private static void solve(int idx, int cnt, ArrayList<Integer> path) {
		if(cnt == K) {
			int ret = 0, min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				min = Integer.MAX_VALUE;
				for(int j = 0; j < path.size(); j++) {
					if(i == path.get(j)) {
						min = 0;
						break;
					}
					Pair np = arr[path.get(j)];
					
					min = Math.min(min, Math.abs(arr[i].x - np.x) + Math.abs(arr[i].y - np.y));
				}
				ret = Math.max(min, ret);
			}
			
			res = Math.min(res, ret);
			return;
		}
		if(idx == N) return;
		
		for(int i = idx; i < N; i++) {
			chk[i] = true;
			path.add(i);
			solve(i + 1, cnt + 1, path);
			path.remove(path.size() - 1);
			chk[i] = false;
		}
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}