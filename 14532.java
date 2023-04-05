import java.util.*;

public class Main {
	static int N, res = 0;
	static boolean flag = false;
	static char[][] map;
	static ArrayList<Integer> number;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		number = new ArrayList<>();
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < N; j++)
				if(map[i][j] != '0') {
					if(hs.contains(map[i][j] - '0')) continue;
					hs.add(map[i][j] - '0');
					number.add(map[i][j] - '0');
				}
		}
		
		ArrayList<Integer> path = new ArrayList<>();
		for(int i = 0; i < number.size(); i++) {
			flag = false;
			path.add(number.get(i));
			solve(1, (1<<i), path);
			if(flag) res += 1;
			path.remove(path.size() - 1);
		}
		
		System.out.println(res);
	}
	private static void solve(int cnt, int chk, ArrayList<Integer> path) {
		if(flag) return;
		if(cnt == number.size()) {
			flag = find(path);
			return;
		}
		
		for(int i = 0; i < number.size(); i++) {
			if((chk&(1<<i)) != 0) continue;
			path.add(number.get(i));
			solve(cnt + 1, chk|(1<<i), path);
			path.remove(path.size() - 1);
		}
	}
	private static boolean find(ArrayList<Integer> path) {
		char[][] tmp = new char[N][N];
		for(int i = 0; i < N; i++) Arrays.fill(tmp[i], '0');
		
		for(int k = 0; k < path.size(); k++) {
			char num = (char)(path.get(k) + '0');
			//최소 x, 최대 x, 최소 y, 최대 y 찾기
			int sx = N, sy = N, ex = 0, ey = 0;
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					if(map[i][j] == num) {
						sx = Math.min(sx, i);
						sy = Math.min(sy, j);
						ex = Math.max(ex, i);
						ey = Math.max(ey, j);
					}
			
			for(int i = sx; i <= ex; i++)
				for(int j = sy; j <= ey; j++)
					tmp[i][j] = num;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				if(tmp[i][j] != map[i][j]) return false;
		}
		
		return true;
	}
}